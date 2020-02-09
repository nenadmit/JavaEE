<%@include file="commons/top.jspf" %>
    <title>Welcome</title>
  </head>
  <body>




<style>
    form {
        width: 450px;
        height: 600px;
        margin: auto;
        position: relative;
    }
    input {
        width: 375px;
        height: 25px;
    }
    input[type="date"] {
        background-color: white;
        outline: none;
    }

    input[type="date"]::-webkit-clear-button {
        font-size: 18px;
        height: 30px;
        position: relative;
    }

    input[type="date"]::-webkit-inner-spin-button {
        height: 28px;
    }

    input[type="date"]::-webkit-calendar-picker-indicator {
        font-size: 15px;
    }



</style>
<%@include file="commons/nav-bar.jspf" %>
<h2 class="text-center">Add a court session</h2>

 <div>
  <form action="/myWebApp/addCourtSession" method="post" id="mainnForm" class="myDiv ">

      <div class="form-row">
          <div class="form-group col-md-6">
              <label for="regNumber">Registration Number</label>
              <input type="text" class="form-control" name="regNumber" id="regNumber" placeholder="Register Number">
          </div>
          <div class="form-group col-md-6">
              <label for="court">Court</label>
              <input type="text" class="form-control" name="court" id="court" placeholder="Court">
          </div>
      </div>

      <div class="form-row">
          <div class="form-group col-md-6">
              <label for="client">Client</label>
              <input type="text" class="form-control" name="client" id="client" placeholder="Client">
          </div>
          <div class="form-group col-md-6">
              <label for="against">Against</label>
              <input type="text" class="form-control" name="against" id="against" placeholder="Client">
          </div>
      </div>


      <div class="form-row">
          <div class="form-group col-md-6">
              <label for="time">Time</label>
              <input type="time" class="form-control" id="time" name="time" min='06:00' max='18:00'>
          </div>

          <div class="form-group col-md-6">
              <label for="date">Date</label>
              <input type="date" class="form-control" id="date" name="date" min="2020-01-01" max="2045-01-01">
          </div>
          <div class="form-group col-md-6">
              <label for="courtRoom">Court Room</label>
              <input type="text" class="form-control" id="courtRoom"  name="courtRoom" placeholder="Court Room">
          </div>
      </div>

      <div class="form-group">
          <label>Aditional Info</label>
          <textarea form="mainnForm" name="aditionalInfo" class="form-control" >

          </textarea>
      </div>

      <button type="submit" class="btn btn-primary">Add</button>
      ${sucessfull}
  </form>



  <%@include file="commons/scripts.jspf" %>
  </body>
</html>
