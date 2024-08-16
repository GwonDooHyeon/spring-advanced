package spring.advanced.app.v5;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.advanced.trace.callback.TraceCallBack;
import spring.advanced.trace.callback.TraceTemplate;
import spring.advanced.trace.logtrace.LogTrace;
import spring.advanced.trace.template.AbstractTemplate;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final TraceTemplate template;

    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId) {
        return template.execute("OrderControllerV5.request()", new TraceCallBack<String>() {

            @Override
            public String call() {
                orderService.orderItem(itemId);
                return "OK";
            }
        });
    }
}
