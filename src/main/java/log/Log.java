package log;

import kafka.Topic;
import utils.JsonUtils;

abstract public class Log implements Topic {
    public String toJson() {
        return JsonUtils.toJson(this);
    }

    abstract public String getTopic();
}
