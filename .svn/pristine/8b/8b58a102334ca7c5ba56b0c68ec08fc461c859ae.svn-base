/**
 * Ajax分页函数
 * @param  func			用于提交ajax函数
 * @param  totalPage	总页数
 * @param  currentPage	当前页
 * @param  pageSize		页面大小
 * @return 
 */
function companyPage(func,totalPage, currentPage, pageSize) {
	if(parseInt(currentPage)>parseInt(totalPage)){
		currentPage=totalPage;
	}
	if(parseInt(currentPage)<=0){
		currentPage=1;
	}
	
	var tr="";
	if(parseInt(currentPage)==1){
		tr+="<span><font color='#CCCCCC'>首页</font>&nbsp;&nbsp;&nbsp;";
		tr+="<span><font color='#CCCCCC'>上一页</font>&nbsp;&nbsp;&nbsp;";
	}else{
		tr+="<span><a href='javascript:getListByPage(1,"+pageSize+");'>首页</a>&nbsp;&nbsp;&nbsp;";
		tr+="<a href=\"javascript:"+ func +"("+(parseInt(currentPage)-1)+","+pageSize+");\">"+"上一页</a>&nbsp;&nbsp;&nbsp;"
	}
	var endtr="";
	if(parseInt(currentPage)>=parseInt(totalPage)){
		endtr+="<span><font color='#CCCCCC'>下一页</font>&nbsp;&nbsp;&nbsp;";
		endtr+="<span><font color='#CCCCCC'>末页</font>&nbsp;&nbsp;&nbsp;";
	}else{
		endtr+="<a href=\"javascript:"+func +"("+(parseInt(currentPage)+1)+","+pageSize+");\">"+"下一页</a>&nbsp;&nbsp;&nbsp;"
		endtr+="<a href='javascript:"+func+"("+totalPage+","+pageSize+");'>末页</a>&nbsp;&nbsp;&nbsp;";
	}
	
//	endtr+="跳转到<input type='text' id='goPage' name='go' size='4' maxlength='4' />页<input type='button' onclick='javascript:findByGo("+pageSize+")' value='GO'/></span>";

	return tr+endtr;
}