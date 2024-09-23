<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<title>Đăng ký</title>

<content tag="main-body">
	<div class="container">
          <div class="col-md-9 col-sm-9">
          	<div class="row">
          		<div class="col-md-3 col-sm-3"><h1>Đăng ký</h1></div>
          		<div class="col-md-7 col-sm-7">
		          	<c:if test="${alert !=null}">
						<h5 class="mt-2 text-danger fs-6 fw-bolder">${alert}</h5>
					</c:if>
	            </div>
          	</div>
            <div class="content-form-page">
              <div class="row">
                <div class="col-md-7 col-sm-7">
                  <form class="form-horizontal form-without-legend" role="form"
                  	action="/webhan/register" method="post" enctype="multipart/form-data">
                  	<div class="form-group">
                      <label for="name" class="col-lg-4 control-label">Họ tên <span class="require">*</span></label>
                      <div class="col-lg-8">
                        <input type="text" class="form-control" id="name" name="full-name" required>
                      </div>
                    </div>
                  	<div class="form-group">
                      <label for="email" class="col-lg-4 control-label">Email <span class="require">*</span></label>
                      <div class="col-lg-8">
                        <input type="email" class="form-control" id="email" name="email" required>
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="password" class="col-lg-4 control-label">Mật khẩu <span class="require">*</span></label>
                      <div class="col-lg-8">
                        <input type="password" class="form-control" id="password" name="password" required>
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="cp" class="col-lg-4 control-label">Nhập lại mật khẩu <span class="require">*</span></label>
                      <div class="col-lg-8">
                        <input type="password" class="form-control" id="cp" name="password-cf" required>
                      </div>
                    </div>
                    <div class="form-group">
						<label class="col-lg-4 control-label">Ảnh đại diện</label> 
						<div class="col-lg-8">
							<input class="form-control" name="img" type="file">
						</div>
					</div>
                    <div class="row">
                      <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
                        <button type="submit" class="btn btn-primary">Đăng ký</button>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
                        <a href="/webhan/login">Đã có tài khoản? Đăng nhập ngay</a>
                      </div>
                    </div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</content>