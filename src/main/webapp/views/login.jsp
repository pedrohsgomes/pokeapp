<div ng-show="invalid" class="alert alert-danger">{{error}}</div>
<form name="form" ng-submit="login()" role="form" ng-init="username='';password=''">
    <div class="form-group">
        <label for="username">Username</label>
        <i class="fa fa-key"></i>
        <input type="text" name="username" id="username" class="form-control" ng-model="username" required />
        <span ng-show="form.username.$dirty && form.username.$error.required" class="help-block">Username is required</span>
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <i class="fa fa-lock"></i>
        <input type="password" name="password" id="password" class="form-control" ng-model="password" required />
        <span ng-show="form.password.$dirty && form.password.$error.required" class="help-block">Password is required</span>
    </div>
    <div class="btn-group">
        <button type="submit" ng-disabled="form.$invalid || dataLoading" class="btn btn-primary">
			<span class="glyphicon glyphicon-log-in"></span> Login</button>
        <button type="button" ng-disabled="dataLoading" ng-click="register()" class="btn btn-success">Register</button>
    </div>
</form>