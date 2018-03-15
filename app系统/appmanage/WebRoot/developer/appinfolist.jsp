<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<script type="text/javascript">
	$(function(){
		//获取状态
		$("#sta option").each(function(){
			if($(this).val()=="${vo.status}"){
			$(this).attr("selected","selected");
			return;
			};
		});
		//获取平台
		$.getJSON("backend/findbytype.html",{"typeCode":"APP_FLATFORM"},function(res){
			var str="<option value='0'>--请选择--</option>"
			$(res).each(function(){
				str+="<option value="+this.valueid+">"+this.valuename+"</option>"
			});
			$("#flat").html(str);
			$("#flat option").each(function(){
				if($(this).val()=="${vo.flatformId}"){
				$(this).attr("selected","selected");
				return;
				}
			});
		});
		/* 获取1级菜单 */
		
			$.getJSON("backend/findcate.html",function(res){
			var cate="<option value='0'>--请选择--</option>";
			$(res).each(function(){
				if(this.parentid==-1){
					cate+="<option value="+this.id+">"+this.categoryname+"</option>";
				}
			});
			$("#categoryLevel1").html(cate);
			$("#categoryLevel1 option").each(function(){
				if($(this).val()=="${vo.categoryLevel1}"){
					$(this).attr("selected","selected");
					return;
				};
			});
			//3级菜单
			$("#categoryLevel2").change(function(){
			var cate3="<option value='0'>--请选择--</option>";
				$(res).each(function(){
				if(this.parentid==$("#categoryLevel2").val()){	
					cate3+="<option value="+this.id+">"+this.categoryname+"</option>";
				}
			});
			$("#categoryLevel3").html(cate3);
			
			});
			//2级菜单
			$("#categoryLevel1").change(function(){
			var cate2="<option value='0'>--请选择--</option>";
				$(res).each(function(){
				if(this.parentid==$("#categoryLevel1").val()){
					
					cate2+="<option value="+this.id+">"+this.categoryname+"</option>";
				}
			});
			$("#categoryLevel2").html(cate2);
			
			var cate3="<option value='0'>--请选择--</option>";
				$(res).each(function(){
				if(this.parentid==$("#categoryLevel2").val()){	
					cate3+="<option value="+this.id+">"+this.categoryname+"</option>";
				}
			});
			$("#categoryLevel3").html(cate3);
			});
			//2级移入改变
			$("#categoryLevel2").mouseover(function(){
			var cate2="<option value='0'>--请选择--</option>";
				$(res).each(function(){
				if(this.parentid==$("#categoryLevel1").val()){
					
					cate2+="<option value="+this.id+">"+this.categoryname+"</option>";
				}
			});
			$("#categoryLevel2").html(cate2);
			$("#categoryLevel2 option").each(function(){
				if($(this).val()=="${vo.categoryLevel2}"){
					$(this).attr("selected","selected");
					return;
				};
			});
			});
			//3级移入
			$("#categoryLevel3").mouseover(function(){
			var cate3="<option value='0'>--请选择--</option>";
				$(res).each(function(){
				if(this.parentid==$("#categoryLevel2").val()){	
					cate3+="<option value="+this.id+">"+this.categoryname+"</option>";
				}
			});
			$("#categoryLevel3").html(cate3);
			$("#categoryLevel3 option").each(function(){
				if($(this).val()=="${vo.categoryLevel3}"){
					$(this).attr("selected","selected");
					return;
				};
			});
			});
		});
	});
</script>
<div class="clearfix"></div>
<div class="row">
	<div class="col-md-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					APP 信息管理维护 <i class="fa fa-user"></i><small>测试001
						- 您可以通过搜索或者其他的筛选项对APP的信息进行修改、删除等管理操作。^_^</small>
				</h2>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<form method="post" action="backend/infoye.html">	
			    <ul>
					<li>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">软件名称</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input name="infoname" type="text" class="form-control col-md-7 col-xs-12" value="${vo.infoname}">
							</div>
						</div>
					</li>
					
					<li>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">APP状态</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<select name="status" class="form-control" id="sta">									
									   <option value="0">--请选择--</option>
									 <option value="1">待审核</option>
									  <option value="2">审核通过</option>
									   <option value="3">审核未通过</option>
									    <option value="4">已上架</option>
									  <option value="5">已下架</option>
        						</select>
							</div>
						</div>
					</li>
					<li>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">所属平台</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<select name="flatformId" class="form-control" id="flat">
									  
        						</select>
							</div>
						</div>
					</li>
					<li>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">一级分类</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<select id="categoryLevel1" name="categoryLevel1" class="form-control">							
									    
        						</select>
							</div>
						</div>
					</li>
					<li>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">二级分类</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="hidden" name="categorylevel2list" id="categorylevel2list"/>
        						<select name="categoryLevel2" id="categoryLevel2" class="form-control">
        							<c:forEach items="${catename }" var="cn">
        							<c:if test="${vo.categoryLevel2 eq cn.id}">
										<option value='${vo.categoryLevel2 }'>${cn.categoryname }</option>
									</c:if>
        							</c:forEach>
        							<option value='0'>--请选择--</option>
        						</select>
							</div>
						</div>
					</li>
					<li>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">三级分类</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
        						<select name="categoryLevel3" id="categoryLevel3" class="form-control">
        							  <c:forEach items="${catename }" var="cn">
        							<c:if test="${vo.categoryLevel3 eq cn.id}">
										<option value='${vo.categoryLevel3 }'>${cn.categoryname }</option>
									</c:if>
        							</c:forEach>
									 <option value="0">--请选择--</option>
        						</select>
							</div>
						</div>
					</li>
					<li><button type="submit" class="btn btn-primary"> 查 &nbsp;&nbsp;&nbsp;&nbsp;询 </button></li>
				</ul>
			</form>
		</div>
	</div>
</div>
<div class="col-md-12 col-sm-12 col-xs-12">
	<div class="x_panel">
		<div class="x_content">
			<p class="text-muted font-13 m-b-30"></p>
			<div id="datatable-responsive_wrapper"
				class="dataTables_wrapper form-inline dt-bootstrap no-footer">
				<div class="row">
					<div class="col-sm-12">
					<a href="developer/appinfoadd.jsp" class="btn btn-success btn-sm">新增APP基础信息</a>
						<table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap dataTable no-footer dtr-inline collapsed"
							cellspacing="0" width="100%" role="grid" aria-describedby="datatable-responsive_info" style="width: 100%;">
							<thead>
								<tr role="row">
									<th class="sorting_asc" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="First name: activate to sort column descending"
										aria-sort="ascending">软件名称</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										APK名称</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										软件大小(单位:M)</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										所属平台</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										所属分类(一级分类、二级分类、三级分类)</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										状态</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										下载次数</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										最新版本号</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										style="width: 124px;"
										aria-label="Last name: activate to sort column ascending">
										操作</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${pu.list }" var="in">
									<tr role="row" class="odd">
										<td tabindex="0" class="sorting_1">${in.softwarename }</td>
										<td>${in.apkname }</td>
										<td>${in.softwaresize }</td>
										<td>${in.fname }</td>
										<td>${in.t1 } -> ${in.t2 } -> ${in.t3 }</td>
										<td>${in.sname }</td>
										<td>${in.downloads }</td>
										<td>${in.versionid }</td>
										<td>
										<div class="btn-group">
                      <button type="button" class="btn btn-danger">点击操作</button>
                      <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                        <span class="caret"></span>
                        <span class="sr-only">Toggle Dropdown</span>
                      </button>
                      <ul class="dropdown-menu" role="menu">
                        <li>   	
						<a class="saleSwichOpen" saleSwitch="open"  href="#" data-toggle="tooltip" data-placement="top" title="" data-original-title="恭喜您，您的审核已经通过，您可以点击上架发布您的APP">上架</a>			
                        </li>
                        <li><a class="addVersion" href="developer/verid.html?id=${in.id }&sid=1" data-toggle="tooltip" data-placement="top" title="" data-original-title="新增APP版本信息">新增版本</a>
                        </li>
                        <li><a class="modifyVersion" href="developer/verid.html?id=${in.id }&sid=2" data-toggle="tooltip" data-placement="top" title="" data-original-title="修改APP最新版本信息">修改版本</a>
                        </li>
                        <li><a  class="modifyAppInfo" href="developer/verid.html?id=${in.id }&sid=3" data-toggle="tooltip" data-placement="top" title="" data-original-title="修改APP基础信息">修改</a></li>
                        <li><a  class="viewApp"  href="developer/verid.html?id=${in.id }&sid=4"  data-toggle="tooltip" data-placement="top" title="" data-original-title="查看APP基础信息以及全部版本信息">查看</a></li>
						<li><a  class="deleteApp" href="#"  data-toggle="tooltip" data-placement="top" title="" data-original-title="删除APP基础信息以及全部版本信息">删除</a></li>
                      </ul>
                    </div>
						</td>
				</tr>
				</c:forEach>
				</tbody>
				</table>
				</div>
			</div>
			<div class="row">
					<div class="col-sm-5">
						<div class="dataTables_info" id="datatable-responsive_info"
							role="status" aria-live="polite">共${pu.maxCount }条记录
							${pu.pageNo }/${pu.maxPage }页</div>
					</div>
					<div class="col-sm-7">
						<div class="dataTables_paginate paging_simple_numbers"
							id="datatable-responsive_paginate">
							<ul class="pagination">
							
									<li class="paginate_button previous"><a
										href="backend/infoye.html?pageno=1&infoname=${vo.infoname }&flatformId=${vo.flatformId}&categoryLevel1=${vo.categoryLevel1}&categoryLevel2=${vo.categoryLevel2}&categoryLevel3=${vo.categoryLevel3}&status=${vo.status}"
										aria-controls="datatable-responsive" data-dt-idx="0"
										tabindex="0">首页</a>
									</li>
									<li class="paginate_button "><a
									href="backend/infoye.html?pageno=${pu.ago }&infoname=${vo.infoname }&flatformId=${vo.flatformId}&categoryLevel1=${vo.categoryLevel1}&categoryLevel2=${vo.categoryLevel2}&categoryLevel3=${vo.categoryLevel3}&status=${vo.status}"
										aria-controls="datatable-responsive" data-dt-idx="1"
										tabindex="0">上一页</a>
									</li>
								
								
									<li class="paginate_button "><a
										href="backend/infoye.html?pageno=${pu.after }&infoname=${vo.infoname }&flatformId=${vo.flatformId}&categoryLevel1=${vo.categoryLevel1}&categoryLevel2=${vo.categoryLevel2}&categoryLevel3=${vo.categoryLevel3}&status=${vo.status}"
										aria-controls="datatable-responsive" data-dt-idx="1"
										tabindex="0">下一页</a>
									</li>
									<li class="paginate_button next"><a
										href="backend/infoye.html?pageno=${pu.maxPage }&infoname=${vo.infoname }&flatformId=${vo.flatformId}&categoryLevel1=${vo.categoryLevel1}&categoryLevel2=${vo.categoryLevel2}&categoryLevel3=${vo.categoryLevel3}&status=${vo.status}"
										aria-controls="datatable-responsive" data-dt-idx="7"
										tabindex="0">最后一页</a>
									</li>
								
							</ul>
						</div>
					</div>
				</div>
		</div>
	</div>
</div>
</div>
<%@include file="common/footer.jsp"%>
<script src="${pageContext.request.contextPath }/statics/localjs/rollpage.js"></script>
<script src="${pageContext.request.contextPath }/statics/localjs/appinfolist.js"></script>