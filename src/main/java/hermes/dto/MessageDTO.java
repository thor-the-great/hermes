package hermes.dto;

import java.io.Serializable;

public class MessageDTO implements Serializable {

    String msg;
    int idx;

    public MessageDTO(String msg, int idx) {
        this.msg = msg;
        this.idx = idx;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MessageDTO : ").append(" msg = ").append(msg).append(", idx = ").append(idx);
        return sb.toString();
    }
}
