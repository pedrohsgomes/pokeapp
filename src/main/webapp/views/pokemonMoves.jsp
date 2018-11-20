<title>Management Pokemons Team</title>

<p>
	<a href="#/!">Home</a></a>
	<p><a href="#!managerTeams" >Manager Teams</a></a></p>
	<p><a href="#!managerPokemonsTeam/{{teamName}}/" >Manager Pokemons (Team - {{teamName}})</a></a></p>
</p>

<div class="row" ng-controller="pokemonMovesController">
	
	<div class="list-group">
		<img class="circle" src="{{ pokemonParam.sprites.frontDefault }}"alt="icon">
		<h4>Pokemon - {{pokemonParam.name}}</h4>
	</div>
	
	<table class="table table-hover">
           <thead>
               <tr>
                   <th>Move</th>
                   <th>Power</th>
                   <th>Accuracy</th>
                   <th>Effect Chance</th>
                   <th>Power Points</th>
                   <th>Type</th>
                   <th width="10%"></th>
               </tr>
           </thead>
           <tbody>
               <tr ng-repeat="move in pokemonParam.moves">
                   <td><span ng-bind="move.name"></span></td>
                   <td><span ng-bind="move.power"></span></td>
                   <td><span ng-bind="move.accuracy"></span></td>
                   <td><span ng-bind="move.effectChance"></span></td>
                   <td><span ng-bind="move.powerPoints"></span></td>
                   <td><span ng-bind="move.type.name"></span></td>                                     
                   <td>
                      	<div class="form-actions floatRight">
	                   		<button type="button" ng-click="remove(move.name)" class="btn btn-danger custom-width">Remove</button>
                   		</div>
                   </td>
               </tr>
           </tbody>
       </table>
	
	<div class="input-group">
		<input class="form-control" id="search" name="search" placeholder="Search for pokemons" ng-model="query" required="required" />
		<span
			class="input-group-btn">
			<button type="submit" class="btn btn-default">
				<i class="glyphicon glyphicon-search"></i>
			</button>
		</span>
	</div> 
	<br>
	<table class="table table-hover">
           <thead>
               <tr>
                   <th>Move</th>
                   <th width="10%"></th>
               </tr>
           </thead>
           <tbody>
               <tr ng-repeat="move in moves | filter:query">
                   <td><span ng-bind="move.name"></span></td>
                   <td>
                   	<button type="button" ng-click="add(move.name)" class="btn btn-success custom-width">Add</button>
                   </td>
               </tr>
           </tbody>
       </table>
</div>