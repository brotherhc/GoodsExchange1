// 修改------------------------
				$(function(){
					var content=$('.modal-body');
					var disHtml=[];
					var oBtn=$("button[classTag='修改']");
					var str='';
					var oDelete=$("button[classTag='删除']");

					// 找到 title 栏目
					var $oTh=$('.xhbClass th');

					// 确认修改
					$oEditBtn=$("button[classTag='确定修改']").eq(0);
					var oMdal=$("#myModal");
					oDelete.each(function(index,elements){
						
						$(this).on('click',function(){
							$(this).parents('tr').remove();
						});
					});	

					var oTd;
					oBtn.each(function(index,elements){
						
						$(this).on('click',function(){
							//content.html('disHtml[index]')
							if(oMdal.css('display')=='none'){  // 防止重复叠加
								str='';
							}
							oTd=$(this).parents('tr').find('td');
							for(var i=1; i<oTd.length-1; i++){
								//alert(oTd[i].innerHTML)
								str+='<div class="form-group clearfix"><label for="inputPassword" class="col-sm-2 control-label">'+$oTh[i].innerHTML+'</label><div class="col-sm-9"><input type="text" value="'+oTd[i].innerHTML+'" class="form-control myControl" placeholder=""></div></div>	'
							}
							content.html(str);
						});
					});

					// oEditBtn  确认修改

					$oEditBtn.on('click',function(){

						// 获取myControl  修改之后的值

						var oMyControl=$('.myControl');

						for(var i=1; i<oTd.length-1; i++){
							oTd[i].innerHTML=oMyControl[i-1].value;
						}
					});

				})