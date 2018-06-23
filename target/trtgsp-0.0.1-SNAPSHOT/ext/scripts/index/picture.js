var sWidth = 110;//单个容器宽度(包括边距，填充),PS:每次位移距离
var visible = 8;//显示数量
var mr = 0; //向左移动的图片个数（为负值）
var bWidth;//容器宽度
var listLength;//列表图片个数
var listWidth;//列表宽度
var listLeft;//列表位置
var bId; //大容器ID
var listId;//列表ID
var trendLeft;//变化侧栏值
var maxMr;
function init() {
	bId = $("#bigDiv");
	listId = $("#myList");
	bWidth = bId.width();
	listLength = listId.find("li").length;
	alert(listLength);
	listWidth = listLength * sWidth;
	listLeft = parseInt(listId.css('left'));
}
function picList(fx) {
	init();
	maxMr = listLength - visible;
	if (listWidth > bWidth) {
		if (fx == 'next') {
			if (-mr < maxMr) {
				mr--;//每次移动的个数如果我们要移动7个，则为 mr = mr-7;
				trendLeft = mr * sWidth;
				listId.animate( {
					left : trendLeft + "px"
				}, 200);
			}
		} else if (fx == 'pre') {

			if (mr < 0) {
				mr++;
				trendLeft = mr * sWidth;
				listId.animate( {
					left : trendLeft + "px"
				}, 200);
			}
		}
	}

	if (-mr == maxMr) {
		$("input#btnNext").attr("disabled", "disabled");
	} else if (mr == 0) {
		$("input#btnPre").attr("disabled", "disabled");
	} else {
		$("input#btnNext").attr("disabled", "");
		$("input#btnPre").attr("disabled", "");
	}

}
$(function() {
	picList(); //初始化
})