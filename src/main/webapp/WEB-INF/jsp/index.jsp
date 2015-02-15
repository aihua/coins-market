<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Coins</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta name="description" content="Main page"/>
    <meta name="author" content="Viktor Khvostov"/>

    <style type="text/css">
        .table
        {
            display: table;
        }
        .title
        {
            display: table-caption;
            text-align: center;
            font-weight: bold;
            font-size: larger;
        }
        .heading
        {
            display: table-row;
            font-weight: bold;
            text-align: center;
        }
        .row
        {
            display: table-row;
        }
        .cell
        {
            display: table-cell;
            border: solid;
            border-width: thin;
            padding-left: 5px;
            padding-right: 5px;
        }
    </style>
</head>
<body>
<h2>${message}</h2>
<div class="table">
    <div class="title">
        <p>This is a Table</p>
    </div>
    <div class="heading">
        <div class="cell">
            <p>Heading 1</p>
        </div>
        <div class="cell">
            <p>Heading 2</p>
        </div>
        <div class="cell">
            <p>Heading 3</p>
        </div>
    </div>
    <div class="row">
        <div class="cell">
            <p>row 1 Column 1</p>
        </div>
        <div class="cell">
            <p>row 1 Column 2</p>
        </div>
        <div class="cell">
            <p>row 1 Column 3</p>
        </div>
    </div>
    <div class="row">
        <div class="cell">
            <p>row 2 Column 1</p>
        </div>
        <div class="cell">
            <p>row 2 Column 2</p>
        </div>
        <div class="cell">
            <p>row 2 Column 3</p>
        </div>
    </div>
</div>
</body>
</html>
