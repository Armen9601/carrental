<%@ page import="model.Car" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Carbook - Free Bootstrap 4 Template by Colorlib</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">
    
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">

    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/ionicons.min.css">

    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">

    
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">
      <style>
          label.new {
          content: 'Select some files';
          background: -moz-linear-gradient(#15d600, #EBFFFF);
          background: -webkit-gradient(linear, 0 0, 0 100%, from(#4de02c), to(#EBFFFF));
          filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#00BBD6', endColorstr='#EBFFFF');
          padding: 3px 7px;
          color: #333;
          -moz-border-radius: 5px;
          -webkit-border-radius: 5px;
          border-radius: 5px;
          border: 1px solid #666;


      }</style>
  </head>
  <body>
  <%Car carById=(Car)request.getAttribute("detail");%>

  <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
      <div class="container">
          <a class="navbar-brand" href="/home">Car<span>Book</span></a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
              <span class="oi oi-menu"></span> Menu
          </button>

          <div class="collapse navbar-collapse" id="ftco-nav">
              <ul class="navbar-nav ml-auto">
                  <li class="nav-item"><a href="/home" class="nav-link">Home</a></li>
                  <li class="nav-item"><a href="/about" class="nav-link">About</a></li>
                  <li class="nav-item"><a href="/service" class="nav-link">Services</a></li>
                  <li class="nav-item"><a href="/price" class="nav-link">Pricing</a></li>
                  <li class="nav-item"><a href="/car" class="nav-link">Cars</a></li>
                  <li class="nav-item"><a href="/rentedCars" class="nav-link">Rented Cars</a></li>
                  <li class="nav-item"><a href="addcar.jsp" class="nav-link">Add Car</a></li>
                  <li class="nav-item active"><a href="/contact" class="nav-link">Contact</a></li>
              </ul>
          </div>
      </div>
  </nav>
  <!-- END nav -->

  <section class="hero-wrap hero-wrap-2 js-fullheight" style="background-image: url('images/bg_3.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
          <div class="row no-gutters slider-text js-fullheight align-items-end justify-content-start">
              <div class="col-md-9 ftco-animate pb-5">
                  <p class="breadcrumbs"><span class="mr-2"><a href="/home">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Add Car <i class="ion-ios-arrow-forward"></i></span></p>
                  <h1 class="mb-3 bread">Add Car</h1>
              </div>
          </div>
      </div>


      <form action="/addCar" class="bg-light p-5 contact-form">
          <div class="form-group">
              <input type="text" class="form-control" placeholder="Brand" name="brand">
          </div>
          <div class="form-group">
              <input type="text" class="form-control" placeholder="Model" name="model">
          </div>
          <div class="form-group">
              <input type="text" class="form-control" placeholder="Year" name="year">
          </div>
          <div class="form-group">
              <input type="text" class="form-control" placeholder="MatorVolume" name="matorVolume">
          </div>
          <div class="form-group">
              <input type="text" class="form-control" placeholder="Price" name="price">
          </div>
          <div class="form-group">
              <label class="new">
                  <i class="new"></i> Browse<input type="file" style="display: none;" name="picture"><br>
              </label>
          </div>
          <div class="form-group">
              <input type="submit" value="Add" class="btn btn-primary py-3 px-5">
          </div>
      </form>

      </div>
      </div>
      <!-- loader -->
      <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


      <script src="js/jquery.min.js"></script>
      <script src="js/jquery-migrate-3.0.1.min.js"></script>
      <script src="js/popper.min.js"></script>
      <script src="js/bootstrap.min.js"></script>
      <script src="js/jquery.easing.1.3.js"></script>
      <script src="js/jquery.waypoints.min.js"></script>
      <script src="js/jquery.stellar.min.js"></script>
      <script src="js/owl.carousel.min.js"></script>
      <script src="js/jquery.magnific-popup.min.js"></script>
      <script src="js/aos.js"></script>
      <script src="js/jquery.animateNumber.min.js"></script>
      <script src="js/bootstrap-datepicker.js"></script>
      <script src="js/jquery.timepicker.min.js"></script>
      <script src="js/scrollax.min.js"></script>
      <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
      <script src="js/google-map.js"></script>
      <script src="js/main.js"></script>

  </body>
</html>