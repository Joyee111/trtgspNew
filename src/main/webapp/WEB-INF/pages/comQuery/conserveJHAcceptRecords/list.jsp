<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="委托储存养护记录" />
</title>

</head>
<script type="text/javascript">
		  function find(s){
	    if(s.value!=""){
			$.post("${ctx}/qualityRecords/qualityQuery/quamap.html",{
			"quamap" : s,
			},function(data){
				if(data){
					var b = data.toString();
					var c = b.split(",");
					$("#dosageforms").val(c[1]);
					$("#specifications").val(c[2]);
					$("#licensenumber").val(c[3]);
					var tt = document.getElementById("quaMedicId");   
       				for(var ll=0;ll<tt.length;ll++){
        				if(c[5]==tt.options[ll].value){
            			tt.options[ll].selected=true;
		               }  
    	           }
				}else{
					return;
				}
			});
	    }else{
	    	$("#dosageforms").val("");
			$("#specifications").val("");
			$("#licensenumber").val("");
	    }
    
    }
    function chaxun(){
	
	 var jianchariqi = $("#jianchariqi").datebox("getValue");
		  var zhi = $("#zhi").datebox("getValue");

		  if(jianchariqi !=''&& zhi!=''&& jianchariqi > zhi){
           alert("开始时间不能早于截止时间");
            return;
		}else{
		var form = document.getElementById("query");
    	form.submit();
		}
		}
</script>


<div>
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">综合查询统计分析&nbsp;>&nbsp;委托储存养护记录</font>
	<div class="tab_con">
		<div class="caozuo_box">
			<form name="query" id="query" action="query.html" method="post">
				<input type="hidden" name="ptmeth" value="${ptmeth}"/>
				<input type="hidden" name="tz" value="${thispage}"/>
				<label for="maintaindate">检查日期:</label>
				<input type="text"  class="easyui-datebox text1" name="jianchariqi" id="jianchariqi" value="${jianchariqi}" data-options="validType:'date'">
				<label for="maintaindate">至:</label>
				<input type="text"  class="easyui-datebox text1" name="zhi" id="zhi" value="${zhi}" data-options="validType:'date'">
				<label for="mingcheng">通用名称:</label>
				<input type="text" name="mingcheng" id="mingcheng" value="${mingcheng}" class="text1"/>
				<label for="pinming">批号:</label>
				<input type="text" name="pihao" id="pihao" value="${pihao}" class="text1">
				<input type="button" class="btn_big"  name="" onclick="chaxun()" value="查询"/>
			</form>
			<%-- 
			<form action="${ctx}/"id="loadFile" method="post" name="f1"	enctype="multipart/form-data">
				<input type="file" style="visibility: hidden" id="loadUp"name="loadUp" onchange="importExcel()"/>
				<input name="ddyy" id="ddyy" type="button" onclick="document.getElementById('loadUp').click()" class="btn_big"
					value="导入" style="margin-left: 827px;margin-top: 20px;"/>
			</form>--%>
				
		</div>
	</div>
	</div>
	<form id="baseForm">
	<input type="hidden" name="thispage" value="${thispage}" />
	<input type="hidden" name="method" value="add"   />
</form>	
<script type="text/javascript">

				function importExcel(){
					///financialManage/fpManage/ajaxUploadUpdate.html
						// FormData 对象
			            var formData = new FormData($("#loadFile")[0]);
						$.ajax({
							url: '${ctx}/comQuery/conserveJHAcceptRecords/ajaxUploadUpdate.html', //用于文件上传的服务器端请求地址
							type:"POST",
							data:formData,
		                    dataType: 'text', //返回值类型 一般设置为json
		                    processData: false,
		                    contentType: false,
		                    cache: false,
		                    async:false,
		                    success: function (data)  //服务器成功响应处理函数
		                    {
								alert(data)
		                        location.reload(true)
		                    }
						})
					
				}
</script>





