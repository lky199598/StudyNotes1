package JavaBean;

import java.util.List;

/*
 * 与指令表对应的实体类
 */
public class Command {
	private int command_id;//主键
	private String name;//名称
	private String description;//描述
	private List<Content> content_list;//一条指令对应的自动回复内容列表
	
	
	public Command() {
	}

	public int getCommand_id() {
		return command_id;
	}

	public void setCommand_id(int command_id) {
		this.command_id = command_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Content> getContent_list() {
		return content_list;
	}

	public void setContent_list(List<Content> content_list) {
		this.content_list = content_list;
	}

}
