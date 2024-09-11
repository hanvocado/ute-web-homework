<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../components/head.jsp"%>
<title>Quên mật khẩu</title>
</head>
<body>
	<section class="vh-100" style="background-color: #eee;">
		<div class="container h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-lg-12 col-xl-11">
					<div class="card text-black" style="border-radius: 25px;">
						<div class="card-body p-md-4">
							<div class="row justify-content-center">
								<div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

									<p class="text-center h4 fw-bold mb-3 mx-1 mx-md-4">QUÊN MẬT KHẨU</p>

									<form class="mx-1 mx-md-4" action="/webhan/forgot-password"
										method="post">
										<div class="d-flex flex-row align-items-center mb-4">
											<div data-mdb-input-init class="form-outline flex-fill mb-0">
												<label class="form-label" for="form3Example1c">Họ
													tên</label> <input type="text" name="full-name" id="form3Example1c"
													class="form-control" required />
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<div data-mdb-input-init class="form-outline flex-fill mb-0">
												<label class="form-label" for="form3Example3c">Email</label>
												<input type="email" name="email" id="form3Example3c"
													class="form-control" required />
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<div data-mdb-input-init class="form-outline flex-fill mb-0">
												<label class="form-label" for="form3Example4c">Mật
													khẩu mới</label> <input type="password" name="password"
													id="form3Example4c" class="form-control" required />
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<div data-mdb-input-init class="form-outline flex-fill mb-0">
												<label class="form-label" for="form3Example4cd">Nhập
													lại mật khẩu</label> <input type="password" name="password-cf"
													id="form3Example4cd" class="form-control" required />
											</div>
										</div>

										<!-- <div class="form-check d-flex justify-content-center mb-5">
											<input class="form-check-input me-2" type="checkbox" value=""
												id="form2Example3c" /> <label class="form-check-label"
												for="form2Example3"> I agree all statements in <a
												href="#!">Terms of service</a>
											</label>
										</div> -->

										<c:if test="${alert !=null}">
											<h3 class="text-danger fs-6 fw-bolder">${alert}</h3>
										</c:if>
										<div class="d-flex justify-content-center mx-5 mb-3 mb-lg-4">
											<button type="submit" data-mdb-button-init
												data-mdb-ripple-init class="btn btn-primary">Submit</button>
										</div>
										<div><a href="/webhan/login">Đăng nhập</a></div>
									</form>
			
								</div>
								<div
									class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

									<img
										src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
										class="img-fluid" alt="Sample image">

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<%@include file="../components/footer.jsp"%>
</body>
</html>