<title>Management Pokemons Team</title>

<p>
	<a href="#/!">Home</a></a>
	<p><a href="#!managerTeams" >Manager Teams</a></a></p>
</p>

<div class="row" ng-controller="pokemonsController">
	<h4>Team - {{teamParam.name}}</h4>
	
	<table class="table table-hover">
           <thead>
               <tr>
                   <th width="20%"></th>
                   <th>#</th>
                   <th>Pokemon</th>
                   <th>Order</th>
                   <th width="20%"></th>
               </tr>
           </thead>
           <tbody>
               <tr ng-repeat="poke in teamParam.pokemons">
               	   <td>
               	   		<img class="circle"
	                          src="{{ poke.sprites.frontDefault }}"
	                          alt="icon" style="width:60%">
	               </td>
                   <td><span ng-bind="poke.id"></span></td>
                   <td><span ng-bind="poke.name"></span></td>
                   <td><span ng-bind="poke.order"></span></td>
                   <td>
                      	<div class="form-actions floatRight">
	                   		<button type="button" ng-click="addMoves(poke.name)" class="btn btn-info custom-width">Moves</button>
	                   		<button type="button" ng-click="remove(poke.name)" class="btn btn-danger custom-width">Remove</button>
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
                   <th>Name</th>
                   <th width="20%"></th>
               </tr>
           </thead>
           <tbody>
               <tr ng-repeat="pokemon in pokemons | filter:query">
                   <td><span ng-bind="pokemon.name"></span></td>
                   <td>
                   	<button type="button" ng-click="add(pokemon.name)" class="btn btn-success custom-width">Add</button>
                   </td>
               </tr>
           </tbody>
       </table>
</div>