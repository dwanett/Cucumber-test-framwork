package fragment;

import io.cucumber.core.resource.Resource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class GherkinResource implements Resource {

    private final URI path;
    private InputStream source;

    public GherkinResource(String source, URI path) {
        this.source = new ByteArrayInputStream(source.getBytes(StandardCharsets.UTF_8));
        this.path = path;
    }

    @Override
    public URI getUri() {
        return path;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return source;
    }
}
