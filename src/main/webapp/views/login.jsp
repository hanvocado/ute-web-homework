<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<title>Đăng nhập</title>

<!-- BEGIN CONTENT -->
<content class="main" tag="main-body">
      <div class="container">
          <div class="col-md-9 col-sm-9">
          	<div class="row">
          		<div class="col-md-3 col-sm-3"><h1>Đăng nhập</h1></div>
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
                  	action="/webhan/login" method="post">
                  	<div class="form-group">
                      <label for="email" class="col-lg-4 control-label">Email <span class="require">*</span></label>
                      <div class="col-lg-8">
                        <input type="text" class="form-control" id="email" name="email">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="password" class="col-lg-4 control-label">Mật khẩu <span class="require">*</span></label>
                      <div class="col-lg-8">
                        <input type="password" class="form-control" id="password" name="password">
                      </div>
                    </div>
                    <div class="form-check d-flex justify-content-center mb-5">
                    	<label class="col-lg-4 control-label" for="form2Example3"> Nhớ tôi </label>
                    	<div class="col-lg-8">
                        <input class="form-check-input" type="checkbox" value=""
												id="form2Example3c" name="remember" />
                      </div>
                    </div>
											 
                    <div class="row">
                      <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
                        <button type="submit" class="btn btn-primary">Đăng nhập</button>
                      </div>
                    </div>
                    
                    <div class="row">
                      <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
                        <a href="/webhan/forgot-password">Quên mật khẩu?</a>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-10 padding-right-30">
                        <hr>
                        <div class="login-socio">
                            <p class="text-muted">or login using:</p>
                            <ul class="social-icons">
                                <li><a href="#" data-original-title="facebook" class="facebook" title="facebook"></a></li>
                                <li><a href="#" data-original-title="Twitter" class="twitter" title="Twitter"></a></li>
                                <li><a href="#" data-original-title="Google Plus" class="googleplus" title="Google Plus"></a></li>
                                <li><a href="#" data-original-title="Linkedin" class="linkedin" title="LinkedIn"></a></li>
                            </ul>
                        </div>
                      </div>
                      
										
                    </div>
                  </form>
                </div>
		          
              </div>
          </div>
          </div>
          </div>
          </content>
          <!-- END CONTENT -->