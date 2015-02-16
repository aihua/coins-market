<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Coins Market</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta name="description" content="Coins Market"/>

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
<div class="table">
    <div class="title">
        <p>Coins</p>
    </div>
    <div class="heading">
        <div class="cell">
            <p>Description</p>
        </div>
        <div class="cell">
            <p>Composition</p>
        </div>
        <div class="cell">
            <p>Country</p>
        </div>
        <div class="cell">
            <p>Year</p>
        </div>
        <div class="cell">
            <p>Circulation</p>
        </div>
        <div class="cell">
            <p>Grade</p>
        </div>
        <div class="cell">
            <p>price</p>
        </div>
    </div>
    <c:forEach var="listValue" items="${coins}">
        <div class="row">
            <div class="cell">
                <p>${listValue.description}</p>
            </div>
            <div class="cell">
                <p>${listValue.composition}</p>
            </div>
            <div class="cell">
                <p>${listValue.country.fullName}</p>
            </div>
            <div class="cell">
                <p>${listValue.year}</p>
            </div>
            <div class="cell">
                <p>${listValue.circulation}</p>
            </div>
            <div class="cell">
                <p>${listValue.grade}</p>
            </div>
            <div class="cell">
                <p>${listValue.price}</p>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
