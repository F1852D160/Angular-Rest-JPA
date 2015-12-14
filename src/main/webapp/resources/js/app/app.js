var app = angular.module('users', [])

app.controller('usersCtrl', function($scope, $http) {
	$scope.users = [];
	$scope.toCreate = {};
	$scope.toUpdate = {};
	$scope.selected = {};
	
	$scope.validations = {
		phone: /^\d+$/,
		letters: /^[a-zA-Z\s]*$/
	}
	
	$http.get('/intranet/api/users').then(
		function success(response) {
			$scope.users = response.data;
		},
		function fail(error) {
			console.log(error)
		}
	);
	
	$scope.editUser = function(user) {
		$scope.selected = user;
		$scope.toUpdate.id = user.id;
		$scope.toUpdate.name = user.name;
		$scope.toUpdate.lastname = user.lastname;
		$scope.toUpdate.motherLastname = user.motherLastname;
		//$scope.toUpdate.birthDate = new Date(user.birthDate);
		$scope.toUpdate.birthDate = user.birthDate;
		$scope.toUpdate.email = user.email;
		$scope.toUpdate.phone = user.phone;
		$('.modal#edit').modal('show');
	}
	
	$scope.reset = function() {
		$scope.toCreate = {};
		$('.modal#new').modal('hide');
	}
	
	$scope.seeUser = function(user) {
		$scope.selected = user;
		$('.modal#details').modal('show');
	}
	
	$scope.doNew = function() {
		$http({
			url: '/intranet/api/users/new',
			method: 'POST',
			data: $scope.toCreate,
			headers: {'Content-Type': 'application/json'}
		}).then(function success(response) {
			console.log(response);
			$scope.users.push(response.data);
			$('.modal#new').modal('hide');
		}, function fail(error) {
			console.log(error);
		})
	}
	
	$scope.deleteUser = function(user) {
		$scope.toDelete = user;
		$('.modal#delete').modal('show');
	}
	
	$scope.doEdit = function() {
		$http({
			url: '/intranet/api/users/update',
			method: 'PUT',
			data: $scope.toUpdate,
			headers: {'Content-Type': 'application/json'}
		}).then(function success(response) {
			$scope.selected.id = response.data.id;
			$scope.selected.name = response.data.name;
			$scope.selected.lastname = response.data.lastname;
			$scope.selected.motherLastname = response.data.motherLastname;
			$scope.selected.birthDate = response.data.birthDate;
			$scope.selected.email = response.data.email;
			$scope.selected.phone = response.data.phone;
			$('.modal#edit').modal('hide');
		}, function fail(error) {
			console.log(error);
		})
	}
	
	$scope.doDelete = function() {
		$http({
			url: '/intranet/api/users/delete',
			method: 'DELETE',
			data: $scope.toDelete,
			headers: {'Content-Type': 'application/json'}
		}).then(function success(response) {
			var index = getIndexById($scope.toDelete.id);
			$scope.users.splice(index, 1);
			$('.modal#delete').modal('hide');
		}, function fail(error) {
			console.log(error);
		})
	}
	
	function findById(id) {
		var found = {};
		for(var key in $scope.users) {
			if($scope.users[key].id === id) {
				found = $scope.users[key];
				break;
			}
		}
		return found;
	}
	
	function getIndexById(id) {
		var index = -1;
		var count = 0;
		for(var key in $scope.users) {
			if($scope.users[key].id === id) {
				index = count;
				break;
			}
			count++;
		}
		return index;
	}
})