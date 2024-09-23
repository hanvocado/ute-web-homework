<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<title>Tài khoản của tôi</title>

<content tag="main-body">
	<div class="container">
          <div class="col-md-10 col-sm-10">
          	<div class="row mb-5">
          		<div class="col-md-5 col-sm-5">
          			<div class="row">
	          			<div class="col-sm-1 col-md-2">
		          			<img alt="" src="uploads/${user.img}"
											class="border p-2"
											style="width: 40px; height: 40px; border-radius: 50%!important;">
	          			
	          			</div>
          				<div class="col-sm-12 col-md-10 padding-top-10"><h1>Tài khoản của tôi</h1></div>
          			
          			</div>
          		</div>
          		<div class="col-md-7 col-sm-7">
		          	<c:if test="${alert !=null}">
						<h5 class="mt-2 text-danger fs-6 fw-bolder">${alert}</h5>
					</c:if>
	            </div>
          	</div>
            <div class="content-form-page">
              <div class="row">
                  <form class="form-horizontal form-without-legend" role="form"
                  	action="/webhan/account" method="post" enctype="multipart/form-data">

                  	<div class="row">
                  		<div class="col-sm-6 col-md-6">
		                  	
		                  	<div class="form-group">
		                      <label for="fullname" class="col-lg-4 control-label">Họ tên <span class="require">*</span></label>
		                      <div class="col-lg-8">
		                        <input type="text" class="form-control" id="fullname" name="full-name" value="${user.fullname}" required>
		                      </div>
		                    </div>
		                  	<div class="form-group">
		                      <label for="email" class="col-lg-4 control-label">Email <span class="require">*</span></label>
		                      <div class="col-lg-8">
		                        <input type="email" class="form-control" id="email" name="email" value="${user.email}" required >
		                      </div>
		                    </div>
		                    <div class="form-group">
		                      <label for="phone" class="col-lg-4 control-label">Số điện thoại <span class="require">*</span></label>
		                      <div class="col-lg-8">
		                        <input type="text" class="form-control" id="phone" name="phone" value="${user.phone}" required >
		                      </div>
		                    </div>
		                    
		                    <div class="form-group">
								<label class="col-lg-4 control-label">Ảnh đại diện</label> 
								<div class="col-lg-8">
									<input class="form-control" name="img" type="file">
								</div>
							</div>
                  		</div>
                  		<div class="col-sm-6 col-md-6">
							<div class="form-group">
		                      <label for="password" class="col-lg-4 control-label">Mật khẩu hiện tại <span class="require">*</span></label>
		                      <div class="col-lg-8">
		                        <input type="password" class="form-control" id="password" name="old-password" required>
		                      </div>
		                    </div>
		                    <div class="form-group">
		                      <label for="npassword" class="col-lg-4 control-label">Mật khẩu mới</label>
		                      <div class="col-lg-8">
		                        <input type="password" class="form-control" id="npassword" name="new-password">
		                      </div>
		                    </div>
		                    <div class="form-group">
		                      <label for="cp" class="col-lg-4 control-label">Nhập lại mật khẩu</label>
		                      <div class="col-lg-8">
		                        <input type="password" class="form-control" id="cp" name="password-cf">
		                      </div>
                  		</div>
                  	</div>
                  	</div>
                    <div class="row">
                      <div class="padding-left-0 padding-top-20 text-center">
                        <button type="submit" class="btn btn-primary">Cập nhật</button>
                      </div>
                    </div>
					</form>
				</div>
			</div>
		</div>
</div>
	</content>