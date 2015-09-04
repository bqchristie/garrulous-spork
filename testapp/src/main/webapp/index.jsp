<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="//cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css"/>
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"></link>

    <script src="//code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="//cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js"></script>

    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <style>
        body {
            padding-top: 70px;
        }
    </style>
</head>

<body>
<div class="container">
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Insight Action Test</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav pull-right">
                    <li class="active" data-target="product-section"><a href="#">Products</a></li>
                    <li  data-target="store-section"><a href="#">Stores</a></li>
                    <li data-target="data-section"><a href="#" data-target="data-section">Data</a></li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
    </nav>
    <div class="row-fluid">
        <div class="col-md-12">
            <div id="product-section" class="section">
                <h1>Products</h1>
                <table id="product" class="display" cellspacing="0" width="100%">
                </table>
            </div>
        </div>
        <div id="store-section" class="section">
            <h1>Stores</h1>
            <table id="stores" class="display" cellspacing="0" width="100%">
            </table>
        </div>
        <div id="data-section" class="section">
            <h1>Data</h1>
            <table id="data" class="display" cellspacing="0" width="100%">
            </table>
        </div>
    </div>
</div>
</div>
</div>
</body>
<script>
    $(document).ready(function () {

        //load data and on success init tables

        $(".navbar-nav li").click(function(e){
            e.stopPropagation();
            $(".navbar-nav li").removeClass("active");
            $(this).addClass("active");


            var section = "#" + $(this).attr("data-target");
            console.log(section);
            $(".section").hide();
            $(section).show();


        });

        $('#product').DataTable(
                {
                    "ajax": "api",
                    "columns": [
                        {"data": "id", title: "ID"},
                        {"data": "productname", title: "Product Name"},
                        {"data": "classid", title: "Class"}
                    ]
                }
        );

        $('#stores').DataTable(
                {
                    "ajax": "api",
                    "columns": [
                        {"data": "id", title: "ID"},
                        {"data": "productname", title: "Product Name"},
                        {"data": "classid", title: "Class"}
                    ]
                }
        );

        $('#data').DataTable(
                {
                    "ajax": "api",
                    "columns": [
                        {"data": "id", title: "ID"},
                        {"data": "productname", title: "Product Name"},
                        {"data": "classid", title: "Class"}
                    ]
                }
        );

    });

    /* for some reason the plugin uses alert.  override popup alert.*/
    function alert(str) {
        console.log(str);
    }

</script>
</html>
