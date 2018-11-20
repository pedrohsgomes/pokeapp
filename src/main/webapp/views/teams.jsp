<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Management Teams</title>
<style>
      .username.ng-valid {
          background-color: lightgreen;
      }
      .username.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .username.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }
</style>

<p>
	<a href="#/!">Home</a></a>
</p>

<div class="container" ng-app="pokeApp" ng-controller="teamController">
	<form ng-submit="submit()" name="teamForm" class="form-horizontal">
		<input type="hidden" ng-model="team.user.userName" />
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-2 control-lable" for="file">Team Name</label>
                    <div class="col-md-7">
                        <input type="text" ng-model="team.name" class="form-control input-sm" placeholder="Enter team name"/>
                        <div class="has-error" ng-show="teamForm.$dirty">
                            <span ng-show="teamForm.uname.$error.required">This is a required field</span>
                            <span ng-show="teamForm.uname.$error.minlength">Minimum length required is 3</span>
                            <span ng-show="teamForm.uname.$invalid">This field is invalid </span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-actions floatRight">
                    <input type="submit" value="{{!team.user.userName ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="teamForm.$invalid">
                    <button type="button" ng-click="reset()" class="btn btn-warning btn-sm" ng-disabled="teamForm.$pristine">Reset Form</button>
                </div>
            </div>
        </form>
        
        <table class="table table-hover">
           <thead>
               <tr>
                   <th>Team Name</th>
                   <th width="20%"></th>
               </tr>
           </thead>
           <tbody>
               <tr ng-repeat="team in teams">
                   <td><span ng-bind="team.name"></span></td>
                   <td>
                   	<button type="button" ng-click="edit(team.name)" class="btn btn-success btn-sm">Edit</button>  
                   	<button type="button" ng-click="remove(team.name)" class="btn btn-danger btn-sm">Remove</button>
                   	<button type="button" ng-click="addPokemons(team)" class="btn btn-warning btn-sm">Pokemons</button>
                   </td>
               </tr>
           </tbody>
       </table>
</div>