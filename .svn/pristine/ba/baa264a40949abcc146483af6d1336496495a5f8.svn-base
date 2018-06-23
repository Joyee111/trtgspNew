/*------------------readme-----------------------
下拉树 var0.90
lance 20100530
-----------------------------------------------*/
function downTreeLoad(idStr, treeName, actionUrl, paramList) {
	var s_x = document.getElementById(idStr[0]).getBoundingClientRect().left;
	var s_y = document.getElementById(idStr[0]).getBoundingClientRect().top;
	document.getElementById('suggestBox').style.left = s_x + "px";
	document.getElementById('suggestBox').style.top = s_y + 18 + "px";
	document.getElementById('suggestBox').style.display = '';
	document.getElementById('suggestBox').innerHTML = "<div id='" + treeName
			+ "'></div>"

	$(function() {
		$("#" + treeName)
				.tree(
						{
							data : {
								type : "json",
								opts : {
									method : "POST",
									url : actionUrl
								}
							},
							ui : {
								theme_name : "apple"
							},
							callback : {
								onsearch : function(n, t) {
									t.container.find('.search').removeClass(
											'search');
									n.addClass('search');
								},
								onselect : function(NODE, t) {
									for ( var i = 0; i <= paramList.length - 1; i++) {
										var str = $(NODE).children("a:eq(0)")
												.attr(paramList[i]);
										if (str != null && str != ''
												&& str != 'none'
												&& str != 'undefined') {
											document.getElementById(idStr[i]).value = str;
											downTreeClose();
										}
									}

								}
							}
						});
	});
}

function downTreeClose() {
	document.getElementById('suggestBox').style.display = 'none';
}