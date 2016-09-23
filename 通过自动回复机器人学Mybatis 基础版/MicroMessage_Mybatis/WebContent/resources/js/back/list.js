/**
 * 确认是否删除
 */
function Confirm_Delete() {
	if (!confirm("确认要删除该条记录?"))
		window.event.returnValue = false;
}

/*
 * function count(){ var command = parseInt(
 * document.getElementById("command").value);//获取第一个输入框的值 var description =
 * parseInt( document.getElementById("description").value);//获取第二个输入框的值 var
 * select = document.getElementById('select').value;//获取选择框的值 var result = '';
 * document.getElementById('fruit').value = result;//设置结果输入框的值 }
 */

/**
 * 调用后台单条删除方法
 */
function Delete_One_Message(basePath) {
	$("#mainForm").attr("action", basePath + "DeleteMessageServlet.action");
	$("#mainForm").submit();
}

/**
 * 调用后台批量删除方法
 */

function Delete_Batch_Message(basePath) {
	$("#mainForm").attr("action",
			basePath + "Delete_Batch_Message_Servlet.action");
	$("#mainForm").submit();
}
