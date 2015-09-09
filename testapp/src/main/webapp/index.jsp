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

        .section {
            display: none;
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
                    <li data-target="store-section"><a href="#">Stores</a></li>
                    <li data-target="data-section"><a href="#" data-target="data-section">Store Data</a></li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
    </nav>
    <div id="tables" class="row-fluid">
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
<div class="modal" id="pleaseWaitDialog" data-backdrop="static" data-keyboard="false">
    <div class="modal-body">
        <div class="progress" style="margin-top: 200px;">
            <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
                <span class="sr-only">45% Complete</span>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    $(document).ready(function () {

        var model;

        //load data and on success init tables
        $.get("api", function (data) {
            model = data;
            util.hidePleaseWait();
            $("#product-section").show();

            $('#product').DataTable(
                    {
                        "data": model.products,
                        "columns": [
                            {"data": "id", title: "ID"},
                            {"data": "productname", title: "Product Name"},
                            {"data": "classid", title: "Class"}
                        ]
                    }
            );

            $('#stores').DataTable(
                    {
                        "data": model.stores,
                        "columns": [
                            {"data": "id", title: "ID"},
                            {"data": "storelicenseename", title: "Store Name"},
                            {"data": "state", title: "State"},
                            {"data": "zip", title: "Zip"},

                        ]
                    }
            );

            $('#data').DataTable(
                    {
                        "data": model.storeData,
                        "columns": [
                            {"data": "storelicenseename", title: "Store"},
                            {"data": "productname", title: "Product"},
                            {"data": "year", title: "Yr"},
                            {"data": "period", title: "Prd"},
                            {"data": "retaildollarvol", title: "Ret $"},
                            {"data": "shelfdollarvolv", title: "Shelf $"}

                        ]
                    }
            );
        });


        $(".navbar-nav li").click(function (e) {
            e.stopPropagation();
            $(".navbar-nav li").removeClass("active");
            $(this).addClass("active");


            var section = "#" + $(this).attr("data-target");
            console.log(section);
            $(".section").hide();
            $(section).show();


        });


    });

    var util;
    util = util || (function () {
        var pleaseWaitDiv = $("#pleaseWaitDialog");
        return {
            showPleaseWait: function () {
                pleaseWaitDiv.modal();
            },
            hidePleaseWait: function () {
                pleaseWaitDiv.modal('hide');
            }

        };
    })();

    util.showPleaseWait();

    /* for some reason the plugin uses alert.  override popup alert.*/
    function alert(str) {
        console.log(str);
    }

</script>
</html>
