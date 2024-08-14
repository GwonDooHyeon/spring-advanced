package spring.advanced.trace.logtrace;

import spring.advanced.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus traceStatus);

    void exception(TraceStatus traceStatus, Exception e);
}
