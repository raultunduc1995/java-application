package duke.choice.handler;

import duke.choice.model.Clothing;
import io.helidon.common.http.Http;
import io.helidon.webserver.Handler;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public final class ItemList implements Handler {
    private final List<Clothing> items;

    public ItemList() {
        this(new ArrayList<>());
    }

    public ItemList(List<Clothing> items) {
        this.items = items;
    }

    @Override
    public void accept(ServerRequest serverRequest, @NotNull ServerResponse serverResponse) {
        serverResponse.status(Http.Status.OK_200);
        serverResponse.headers().put("Content-Type", "text/plain; charset=UTF-8");
        final StringBuilder result = new StringBuilder();
        items.forEach(clothing -> result.append(clothing).append("\n"));
        serverResponse.send(result);
    }

    @NotNull
    @Override
    public BiConsumer<ServerRequest, ServerResponse> andThen(@NotNull BiConsumer<? super ServerRequest, ? super ServerResponse> after) {
        return Handler.super.andThen(after);
    }
}
