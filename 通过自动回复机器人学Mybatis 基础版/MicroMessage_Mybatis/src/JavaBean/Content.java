package JavaBean;
/*
 * 与内容表对应的实体类
 */
public class Content {
	private int content_id;//主键
	private String content;//内容
	private int command_id;//关联的Command表主键

	public Content() {
	}

	public int getContent_id() {
		return content_id;
	}

	public void setContent_id(int content_id) {
		this.content_id = content_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCommand_id() {
		return command_id;
	}

	public void setCommand_id(int command_id) {
		this.command_id = command_id;
	}

}
