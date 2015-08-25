function replay(id){
	var comment_content_id=document.getElementById("comment_auth_name"+id);
	var comment_content=document.getElementById("comment_content");
	
	comment_content.value="»Ø¸´ \""+comment_content_id.innerHTML+"\":";
	comment_content.focus();
}
