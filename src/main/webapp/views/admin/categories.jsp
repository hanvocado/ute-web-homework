<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<title>Loại sản phẩm</title>

<body>
	<div class="portlet light">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-cogs font-green-sharp"></i> <span
					class="caption-subject font-green-sharp bold uppercase">
					Loại sản phẩm</span>
			</div>
			<div class="tools">
				<a href="javascript:;" class="collapse"> </a> <a
					href="#portlet-config" data-toggle="modal" class="config"> </a> <a
					href="javascript:;" class="reload"> </a> <a href="javascript:;"
					class="remove"> </a>
			</div>
		</div>
		<div class="portlet-body">
			<div class="table-scrollable">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th scope="col">STT</th>
							<th scope="col"  style="width: 220px !important">Ảnh</th>
							<th scope="col">Tên</th>
							<th scope="col">Trạng thái</th>
							<th scope="col">Hành động</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cateList}" var="cate" varStatus="STT">
							<tr>
								<td>${STT.index+1 }</td>
								
								<td>
									<c:choose>
									    <c:when test="${cate.image.substring(0,5) != 'https'}">
									        <c:url value="/image?fname=${cate.image }" var="imgUrl"></c:url> 
									    </c:when>    
									    <c:otherwise>
									        <c:url value="${cate.image }" var="imgUrl"></c:url> 
									    </c:otherwise>
									</c:choose>
								<img height="150" width="200" src="${imgUrl}" />
								
								</td>
								
								<td>${cate.name }</td>
								
								<td>
									<c:choose>
									    <c:when test="${cate.deleted}">
									        Dừng hoạt động 
									    </c:when>    
									    <c:otherwise>
									        Đang hoạt động 
									    </c:otherwise>
									</c:choose>
								</td>
								
								<td><a
									href="<c:url value='/admin/category/edit?id=${cate.id }'/>"
									class="center">Sửa</a> | 
									<a
									href="<c:url value='/admin/category/delete?id=${cate.id }'/>"
									class="center">Xóa</a>
								</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- END SAMPLE TABLE PORTLET-->
</body>