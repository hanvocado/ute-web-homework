<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<title>Tài khoản của tôi</title>

<content tag="main-body">
	<div class="container-fluid mt-5 p-5 bg-light">
			<div class="row">
				<div class="col-md-10 offset-md-1 ">

					<p class="fs-3 text-center">Tài khoản của tôi</p>

					<hr>
					<div class="text-center">
						<img alt="" src="'../uploads/profile/'+${user.img}}"
							class="border p-2"
							style="width: 110px; height: 110px; border-radius: 50%;">
					</div>
					<div class="col-md-8 offset-md-2 mt-4">
						<table class="table table-borderless">

							<tbody>
								<form action="/webhan/account" method="post"
									enctype="multipart/form-data">
								<tr>
									<th scope="row">Name</th>
									<td>:</td>
									<td><input type="text" name="full-name" class="form-control"
										>${user.fullname}</td>
								</tr>
								<tr>
									<th scope="row">Email</th>
									<td>:</td>
									<td><input type="text" name="email" class="form-control"
										readonly>${user.email}</td>
								</tr>
								<tr>
									<th scope="row">Image</th>
									<td>:</td>
									<td><input type="file" name="img" class="form-control"
										value=""></td>
								</tr>

								<tr>
									<td></td>
									<td class="text-center">
										<button class="btn btn-sm bg-primary text-light">Update</button>
									</td>
								</tr>
								</form>
							</tbody>
						</table>

					</div>

				</div>
				<hr>
				<div class="col-md-10 offset-md-1 mt-1">
					<div class="row">
						<p class="text-center fs-3">Change Password</p>
						<div class="col-md-6 offset-md-3">
							<table class="table table-borderless">

								<tbody>
									<form action="/user/change-password" method="post">
										<tr>
											<th scope="row">Current Password</th>

											<td><input type="text" name="currentPassword" class="form-control"></td>
										</tr>

										<tr>
											<th scope="row">New Password</th>

											<td><input type="text" name="newPassword" class="form-control"></td>
										</tr>

										<tr>
											<th scope="row">Confirm Password</th>

											<td><input type="text" name="confirmPassword" class="form-control"></td>
										</tr>
										<tr>
											<td></td>
											<td class="text-center">
												<button class="btn btn-sm bg-primary text-light col-md-4">Update</button>
											</td>

										</tr>
									</form>
								</tbody>
							</table>
						</div>
					</div>
				</div>

			</div>

		</div>
</content>