<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<title>Buyer Admin Page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
<body>

<!-- Side Navigation -->
<nav class="w3-sidebar w3-bar-block w3-card w3-animate-left w3-center" style="display:none" id="mySidebar">
  <b><h1 class="w3-xxxlarge w3-text-theme" >Admin Responsibilities</h1></b>
  <button class="w3-bar-item w3-button" onclick="w3_close()">Back to Dash board <i class="fa fa-remove"></i></button>
  <a href="buyers.jsp" class="w3-bar-item w3-button">Overall Buyer Management</a>
  <a href="order.jsp" class="w3-bar-item w3-button">Purchase Products</a>
  <a href="purchaseReport.jsp" class="w3-bar-item w3-button">Purchased Product Report</a>
  <a href="profile.jsp" class="w3-bar-item w3-button">Find Buyer According to the ID</a>
</nav>

<!-- Header -->
<header class="w3-container w3-theme w3-padding" id="myHeader">
  <i onclick="w3_open()" class="fa fa-bars w3-xlarge w3-button w3-theme"></i> 
  <div class="w3-center">
  <h4>Buyer Admin Pannel</h4>
  <h1 class="w3-xxxlarge w3-animate-bottom">Buyer Dash Board</h1>
    <div class="w3-padding-32">
      <a href = "https://www.sliit.lk/"><button class="w3-btn w3-xlarge w3-dark-grey w3-hover-light-grey"  style="font-weight:900;">Discover Your Future</button></a>
    </div>
  </div>
</header>

<div class="w3-padding w3-white w3-display-container">
  <span onclick="this.parentElement.style.display='none'" class="w3-button w3-display-topright"><i class="fa fa-remove"></i></span>
  <h2>Facilities</h2>
  <p>As a Buyer Admin, You can Manage overall buyers profiles. That means crud Operations (Insert,update,delete,view).</p>
  <p>Not only that but also you can see their already purchased products as a report.</p>
  <p>And you can purchase products as a buyer if you want. </p>
  <p>The other option is able to see the buyers according to their Buyer ID.</p>
  <p>To see those options you can click on slide menu icon.</p>
</div>
      
  
      <footer class="w3-container w3-theme-l1">
        <p>Read above details carefully!</p>
      </footer>


<br>

<!-- Footer -->
<footer class="w3-container w3-theme-dark w3-padding-16">
  <h3>Footer</h3>
  <p>Powered by <a href="https://www.facebook.com/jayamadhuka.chandramal.9/" target="_blank">IT19014500</a></p>
  <div style="position:relative;bottom:55px;" class="w3-tooltip w3-right">
    <span class="w3-text w3-theme-light w3-padding">Go To Top</span>    
    <a class="w3-text-white" href="#myHeader"><span class="w3-xlarge">
    <i class="fa fa-chevron-circle-up"></i></span></a>
  </div>
  <p>Developer Name  <a href="https://www.facebook.com/jayamadhuka.chandramal.9/" class="w3-btn w3-theme-light" target="_blank">M.H.J.M.J.C. Jayasundara</a></p>
</footer>

<!-- Script for Sidebar, Tabs, Accordions, Progress bars and slideshows -->
<script>
// Side navigation
function w3_open() {
  var x = document.getElementById("mySidebar");
  x.style.width = "100%";
  x.style.fontSize = "40px";
  x.style.paddingTop = "10%";
  x.style.display = "block";
}
function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
}



var mybtn = document.getElementsByClassName("testbtn")[0];
mybtn.click();

// Accordions
function myAccFunc(id) {
  var x = document.getElementById(id);
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else { 
    x.className = x.className.replace(" w3-show", "");
  }
}

// Slideshows
var slideIndex = 1;

function plusDivs(n) {
  slideIndex = slideIndex + n;
  showDivs(slideIndex);
}

function showDivs(n) {
  var x = document.getElementsByClassName("mySlides");
  if (n > x.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = x.length} ;
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  x[slideIndex-1].style.display = "block";  
}

showDivs(1);

// Progress Bars
function move() {
  var elem = document.getElementById("myBar");   
  var width = 5;
  var id = setInterval(frame, 10);
  function frame() {
    if (width == 100) {
      clearInterval(id);
    } else {
      width++; 
      elem.style.width = width + '%'; 
      elem.innerHTML = width * 1  + '%';
    }
  }
}
</script>

</body>
</html>
    