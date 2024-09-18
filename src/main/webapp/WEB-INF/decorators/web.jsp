<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<c:url value="/" var="URL" />
<!DOCTYPE html>
<html>
<!-- HEAD START -->
<head>
<meta charset="UTF-8">
<title><sitemesh:write property="title"/></title>
<link rel="shortcut icon" href="favicon.ico">



  <!-- Global styles START -->          
  <link href="${URL}resources/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="${URL}resources/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Global styles END --> 
   
  <!-- Page level plugin styles START -->
  <link href="${URL}resources/global/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet">
  <link href="${URL}resources/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.css" rel="stylesheet">
  <link href="${URL}resources/global/plugins/slider-layer-slider/css/layerslider.css" rel="stylesheet">
  <!-- Page level plugin styles END -->

  <!-- Theme styles START -->
  <link href="${URL}resources/global/css/components.css" rel="stylesheet">
  <link href="${URL}resources/frontend/layout/css/style.css" rel="stylesheet">
  <link href="${URL}resources/frontend/pages/css/style-shop.css" rel="stylesheet" type="text/css">
  <link href="${URL}resources/frontend/pages/css/style-layer-slider.css" rel="stylesheet">
  <link href="${URL}resources/frontend/layout/css/style-responsive.css" rel="stylesheet">
  <link href="${URL}resources/frontend/layout/css/themes/red.css" rel="stylesheet" id="style-color">
  <link href="${URL}resources/frontend/layout/css/custom.css" rel="stylesheet">
  <!-- Theme styles END -->
</head>
<!-- Head END -->
<body class="ecommerce">
	
    <%@include file="/common/header.jsp"%>
    
	<sitemesh:write property="page.main-body" />
	
	<div>
		<%@include file="/common/footer.jsp"%>
	</div>

</body>
</html>