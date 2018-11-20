<!DOCTYPE html>
<html ng-app="pokeApp">
<head lang="en">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.css">
    <link rel="stylesheet" href="webjars/angular-material/1.1.0/angular-material.css">
    <title>PokeApp</title>
</head>
<body>		
    <div class="jumbotron">
      <div class="container">
        <div class="col-xs-offset-2 col-xs-8">
          <ng-view></ng-view>
        </div>
      </div>
    </div>

    <div class="credits text-center">
      <p>
          <a href="http://pokeapi.co/">PokeApi.co</a>
      </p>
      <p>
        <a href="http://facebook.com/pedrohsgomes">Pedro Gomes</a>
      </p>
    </div>

<script type="text/javascript" src="webjars/jquery/3.2.1/jquery.js"></script>
<script type="text/javascript" src="webjars/angularjs/1.6.4/angular.min.js"></script>
<script type="text/javascript" src="webjars/angularjs/1.6.4/angular-resource.min.js"></script>
<script type="text/javascript" src="webjars/angularjs/1.6.4/angular-route.js"></script>
<script type="text/javascript" src="webjars/angularjs/1.6.4/angular-cookies.js"></script>
<script type="text/javascript" src="webjars/angular-material/1.1.0/angular-material.min.js"></script>
<script type="text/javascript" src="resources/js/app.js"></script>
<script type="text/javascript" src="resources/js/controllers.js"></script>
<script type="text/javascript" src="resources/js/services.js"></script>
<script type="text/javascript" src="resources/js/teamController.js"></script>
<script type="text/javascript" src="resources/js/teamService.js"></script>
<script type="text/javascript" src="resources/js/pokemonController.js"></script>
<script type="text/javascript" src="resources/js/pokemonMoveController.js"></script>
</body>
</html>