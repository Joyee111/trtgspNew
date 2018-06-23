function reportinfo(url,titletxt,usernum,usernumline,countstr,brands) {
jQuery
			.post(
					url,
					{
						starttime : jQuery("#starttimeid").val(),
						endtime : jQuery("#endtimeid").val(),
						stry : jQuery("#countterritoryid").val()
					},
					function(productdata) {
						try {
							var chart;
							var str = [];
							var product = [];
							countstr=countstr+productdata.count;
							jQuery.each(
								productdata.ingredients,
								function(idx, item) {
									str.push(idx);
									product.push(item);
								});
							
							
							var reporttype = jQuery("#countpicid").val() - 0;
							if(null==reporttype||reporttype<1){
								reporttype=1;
							}
							if (reporttype == 1) {
								chart = new Highcharts.Chart( {
									chart : {
										renderTo : 'container',
										defaultSeriesType : 'line',
										marginRight : 130,
										marginBottom : 25
									},
									title : {
										text : titletxt,
										x : -20
									//center
									},
									subtitle : {
										text : countstr,
										x : -20
									},
									xAxis : {
										categories : str
									},
									yAxis : {
										title : {
											text : usernum
										},
										plotLines : [ {
											value : 0,
											width : 1,
											color : '#808080'
										} ]
									},
									tooltip : {
										formatter : function() {
											return '<b>' + this.series.name
													+ '</b><br/>' + this.x
													+ ': ' + this.y ;
										}
									},
									legend : {
										layout : 'vertical',
										align : 'right',
										verticalAlign : 'top',
										x : -10,
										y : 100,
										borderWidth : 0
									},
									series : [ {
										name : usernumline,
										data : product
									} ]
								});
							} else if (reporttype == 2) {
								var colors = Highcharts.getOptions().colors, categories = str, name = brands, data = object;
								var object = [];
								for ( var i = 0; i < product.length; i++) {
									object.push( {
										y : product[i] - 0,
										color : colors[i]
									});
								}
								colors = Highcharts.getOptions().colors, categories = str, name = brands, data = object;
								function (name, categories, data, color) {
									 chart.xAxis[0].setCategories(categories);
									 chart.series[0].remove();
									 chart.addSeries({name: name,data: data,color: color || 'white'});
				                 }
								chart = new Highcharts.Chart(
										{
											chart : {
												renderTo : 'container',
												type : 'column'
											},
											title : {
												text : titletxt
											},
											subtitle : {
												text : countstr
											},
											xAxis : {
												categories : categories
											},
											yAxis : {
												title : {
													text : usernum
												}
											},
											plotOptions : {
												column : {
													cursor : 'pointer',
													point : {
														events : {
															click : function() {
																var drilldown = this.drilldown;
																if (drilldown) { // drill down
																	setChart(
																			drilldown.name,
																			drilldown.categories,
																			drilldown.data,
																			drilldown.color);
																} else { // restore
																	setChart(
																			name,
																			categories,
																			data);
																}
															}
														}
													},
													dataLabels : {
														enabled : true,
														color : colors[0],
														style : {
															fontWeight : 'bold'
														},
														formatter : function() {
															return this.y;
														}
													}
												}
											},
											tooltip : {
												formatter : function() {
													var point = this.point, s = this.x
															+ ':<b>'
															+ this.y;
													
													return s;
												}
											},
											series : [ {
												name : name,
												data : data,
												color : 'white'
											} ],
											exporting : {
												enabled : false
											}
										});
							}else { 
							var object = [];
							 for ( var i = 0; i < product.length; i++) {
									object.push([ str[i],product[i] ]); 
										}
							chart = new Highcharts.Chart({
					chart: {
						renderTo: 'container',
						plotBackgroundColor: null,
						plotBorderWidth: null,
						plotShadow: false
					},
					title: {
						text: titletxt
					},
					subtitle : {
						text : countstr
					},
					tooltip: {
						formatter: function() {
							return '<b>'+ this.point.name +'</b>: '+ this.y ;
						}
					},
					plotOptions: {
						pie: {
							allowPointSelect: true,
							cursor: 'pointer',
							dataLabels: {
								enabled: true,
								color: '#000000',
								connectorColor: '#000000',
								formatter: function() {
									return '<b>'+ this.point.name +'</b>: '+ this.y;
								}
							}
						}
					},
				    series: [{
						type: 'pie',
						name: 'Browser share',
						data: object
					}]
				});
						 }
						} catch (e) {
							alert("Error in XML response:" + e);
						}

					}, 'JSON');
};

function selectsensor(pleaseselect){
	jQuery("#sensorid").removeAttr("disabled");
									var checkText = jQuery("#satellteid").find(
											"option:selected").text();
									jQuery
											.post(
													"../collectInfoEdit.html?method=ajax",
													{
														str11 : checkText
													},
													function(data) {
														try {
															jQuery(
																	"#sensorid option[id='old']")
																	.remove(); //删 除Select的Option
															jQuery("#sensorid")
																	.append(
																			"<option id='old' value='' >"+pleaseselect+"</option>");//拼一个空值 ch
															jQuery
																	.each(
																			data.ingredients,
																			function(
																					idx,
																					item) {
																				jQuery(
																						"#sensorid")
																						.append(
																								"<option id='old' >"
																										+ item
																										+ "</option>"); //为Select追加一个Option(下拉项)
																				//alert(idx+item);
																				if (idx == 0) {
																					return true;//同countinue，返回false同break      
																				}
																			});
														} catch (e) {
															alert("Error in XML response:"
																	+ e);
														}
													}, 'JSON');
};

function reportvisit(url, titletxt,usernum,usernumline,countstr,brands) {
jQuery
			.post(
					url,
					{
						starttime : jQuery("#starttimeid").val(),
						endtime : jQuery("#endtimeid").val(),
						stry : jQuery("#countterritoryid").val()
					},
					function(productdata) {
						try {
							var chart;
							var str=[];
							var productstr=[];
							var product= new Array();
							countstr=countstr+productdata.count;
							var vk=productdata.ingredients.split(",");
							str=vk[0].split("_");
							productstr=vk[1].split("_");
							for(var i =0;i<productstr.length;i++){
								product.push(productstr[i]-0);
							}
							var reporttype = jQuery("#countpicid").val() - 0;
							if(null==reporttype||reporttype<1){
								reporttype=1;
							}
							if (reporttype == 1) {
								chart = new Highcharts.Chart( {
									chart : {
										renderTo : 'container',
										defaultSeriesType : 'line',
										marginRight : 130,
										marginBottom : 25
									},
									title : {
										text : titletxt,
										x : -20
									//center
									},
									subtitle : {
										text : countstr,
										x : -20
									},
									xAxis : {
										categories : str
									},
									yAxis : {
										title : {
											text : usernum
										},
										plotLines : [ {
											value : 0,
											width : 1,
											color : '#808080'
										} ]
									},
									tooltip : {
										formatter : function() {
											return '<b>' + this.series.name
													+ '</b><br/>' + this.x
													+ ': ' + this.y ;
										}
									},
									legend : {
										layout : 'vertical',
										align : 'right',
										verticalAlign : 'top',
										x : -10,
										y : 100,
										borderWidth : 0
									},
									series : [ {
										name : usernumline,
										data : product
									} ]
								});
							} else if (reporttype == 2) {
								var colors = Highcharts.getOptions().colors, categories = str, name = brands, data = object;
								var object = [];
								for ( var i = 0; i < product.length; i++) {
									object.push( {
										y : product[i] - 0,
										color : colors[i]
									});
								}
								colors = Highcharts.getOptions().colors, categories = str, name = brands, data = object;
								function (name, categories, data, color) {
									 chart.xAxis[0].setCategories(categories);
					chart.series[0].remove();
					chart.addSeries({
						name: name,
						data: data,
						color: color || 'white'
					});
				                 }
								chart = new Highcharts.Chart(
										{
											chart : {
												renderTo : 'container',
												type : 'column'
											},
											title : {
												text : titletxt
											},
											subtitle : {
												text : countstr
											},
											xAxis : {
												categories : categories
											},
											yAxis : {
												title : {
													text : usernum
												}
											},
											plotOptions : {
												column : {
													cursor : 'pointer',
													point : {
														events : {
															click : function() {
																var drilldown = this.drilldown;
																if (drilldown) { // drill down
																	setChart(
																			drilldown.name,
																			drilldown.categories,
																			drilldown.data,
																			drilldown.color);
																} else { // restore
																	setChart(
																			name,
																			categories,
																			data);
																}
															}
														}
													},
													dataLabels : {
														enabled : true,
														color : colors[0],
														style : {
															fontWeight : 'bold'
														},
														formatter : function() {
															return this.y;
														}
													}
												}
											},
											tooltip : {
												formatter : function() {
													var point = this.point, s = this.x
															+ ':<b>'
															+ this.y;
													
													return s;
												}
											},
											series : [ {
												name : name,
												data : data,
												color : 'white'
											} ],
											exporting : {
												enabled : false
											}
										});
							}else { 
							var object = [];
							 for ( var i = 0; i < product.length; i++) {
									object.push([ str[i],product[i] ]); 
										}
							chart = new Highcharts.Chart({
					chart: {
						renderTo: 'container',
						plotBackgroundColor: null,
						plotBorderWidth: null,
						plotShadow: false
					},
					title: {
						text: titletxt
					},
					subtitle : {
						text : countstr
					},
					tooltip: {
						formatter: function() {
							return '<b>'+ this.point.name +'</b>: '+ this.y ;
						}
					},
					plotOptions: {
						pie: {
							allowPointSelect: true,
							cursor: 'pointer',
							dataLabels: {
								enabled: true,
								color: '#000000',
								connectorColor: '#000000',
								formatter: function() {
									return '<b>'+ this.point.name +'</b>: '+ this.y;
								}
							}
						}
					},
				    series: [{
						type: 'pie',
						name: 'Browser share',
						data: object
					}]
				});
						 }
						} catch (e) {
							alert("Error in XML response:" + e);
						}

					}, 'JSON');
};