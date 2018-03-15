<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<script type="text/javascript">
	$(function(){
		$("#flatformId option").each(function(){
			if($(this).val()=="${in.flatformid}"){
				$(this).attr("selected","selected");
			}
		});
		$("#categorylevel1").change(function(){
			var c1=$("#categorylevel1").val();
			$.getJSON("backend/findcatepid.html?pid="+c1,function(res){
				var str="<option value='0'>--请选择--</option>";
				$(res).each(function(){
					str+="<option value='"+this.id+"'>"+this.categoryname+"</option>";
				});
				$("#categorylevel2").html(str);
				$("#categorylevel3").html("<option value='0'>--请选择--</option>"	);
			});
		});
		$("#categorylevel2").change(function(){
		var c2=$("#categorylevel2").val();
		$.getJSON("backend/findcatepid.html?pid="+c2,function(res){
			var str="<option value='0'>--请选择--</option>";
			$(res).each(function(){
				str+="<option value='"+this.id+"'>"+this.categoryname+"</option>";
			});
			$("#categorylevel3").html(str);
		});
		});
	});
</script>
<div class="clearfix"></div>
<div class="row">
  <div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
      <div class="x_title">
        <h2>修改APP基础信息 <i class="fa fa-user"></i><small>测试001</small></h2>
             <div class="clearfix"></div>
      </div>
      <div class="x_content">
        <form class="form-horizontal form-label-left" action="developer/updateinfo.html" method="post">
          <input type="hidden" name="id" id="id" value="${in.id}">
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">软件名称 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="softwareName" class="form-control col-md-7 col-xs-12" 
               data-validate-length-range="20" data-validate-words="1" 
               name="softwarename" value="" required="required"
               placeholder="${in.softwarename }" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">APK名称 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="APKName" type="text" class="form-control col-md-7 col-xs-12" 
              name="apkname" value="${in.apkname }" readonly="readonly">
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">支持ROM <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="supportROM" class="form-control col-md-7 col-xs-12" 
              	name="supportrom" value="" required="required"
              	data-validate-length-range="20" data-validate-words="1" 
              	placeholder="${in.supportrom }" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">界面语言 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="interfaceLanguage" class="form-control col-md-7 col-xs-12" 
              data-validate-length-range="20" data-validate-words="1"  required="required"
              name="interfacelanguage" value=""
              placeholder="${in.interfacelanguage }" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">软件大小 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="number" id="softwareSize" name="softwaresize" value="" required="required"
              data-validate-minmax="10,500"  placeholder="${in.softwaresize }" class="form-control col-md-7 col-xs-12">
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">下载次数 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="number" id="downloads" name="downloads" value="" required="required"
              data-validate-minmax="10,500"  placeholder="${in.downloads }" class="form-control col-md-7 col-xs-12">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="select">所属平台 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
             
              <select name="flatformid" id="flatformId" class="form-control" required="required">
              	<c:forEach items="${flatformId }" var="ff">
					<option value="${ff.valueid}">${ff.valuename}</option>
				</c:forEach>
              </select>
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="select">一级分类 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              
              <select name="categorylevel1" id="categorylevel1" class="form-control"  required="required">
              	<option  value="${in.categorylevel1 }">${in.t1 }</option>
              	<c:forEach items="${catename }" var="cn">
               		<c:if test="${cn.parentid eq -1}">
               		<option value="${cn.id}">${cn.categoryname}</option>
               		</c:if>
				</c:forEach>
              </select>
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="select">二级分类 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
            	
              <select name="categorylevel2" id="categorylevel2" class="form-control"  required="required">
              <option  value="${in.categorylevel2 }">${in.t2 }</option>
              </select>
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="select">三级分类 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
             
              <select name="categorylevel3" id="categorylevel3" class="form-control"  required="required">
              <option  value="${in.categorylevel3 }">${in.t3 }</option>
              </select>
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">APP状态 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
            	<input id="statusName" type="text" class="form-control col-md-7 col-xs-12" 
              	name="statusName" value="${in.sname }" readonly="readonly">
              	<input type="hidden" value="${in.status }" name="status">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="textarea">应用简介 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <textarea id="appInfo" name="appinfo" required="required"
             class="form-control col-md-7 col-xs-12">${in.appinfo }</textarea>
            </div>
          </div>
           <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">LOGO图片 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
				<div id="uploadfile" style="display: none">
				<input id="attach"  type="file" class="form-control col-md-7 col-xs-12">
				<p><span style="color:red;font-weight: bold;">*注：1、大小不得超过500k.2、图片格式：jpg、png、jpeg、pneg</span></p>
				</div>
				<div id="logoFile"></div>
				<c:if test="${!empty in.logopicpath}">
						<img src="${in.logopicpath}">
				</c:if>
            </div>
          </div>
          <div class="form-group">
            <div class="col-md-6 col-md-offset-3">
            	
              <button id="send" type="submit" class="btn btn-success">保存</button>
              <button type="button" class="btn btn-primary" id="back">返回</button>
              <br/><br/>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
<%@include file="common/footer.jsp"%>