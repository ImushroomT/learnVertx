import com.jason.ContextVertical;
import io.vertx.core.Vertx;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author qiushengsen
 * @dateTime 2018/5/30 下午10:27
 * @descripiton
 **/
public class VerticleTest {
    @Test
    public void test_context() throws InterruptedException {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new ContextVertical());
        TimeUnit.SECONDS.sleep(10);
    }
}
