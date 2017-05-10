package wmm.javaframe.study.thread;

import org.apache.commons.lang3.time.DurationFormatUtils;

import java.util.concurrent.atomic.LongAccumulator;

/**
 * Created by wangmm on 2017/4/26.
 */
public class LongAdd {

    public static void main(String[] args) {
        Long time=System.currentTimeMillis();
        LongAccumulator accumulator = new LongAccumulator((left, right) -> left + right, 0L);
        accumulator.accumulate(System.currentTimeMillis() - time);
        DurationFormatUtils.formatDurationHMS(accumulator.get());
    }

}
