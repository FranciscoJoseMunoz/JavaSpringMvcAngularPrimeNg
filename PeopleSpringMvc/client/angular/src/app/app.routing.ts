import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PeopleListComponent } from './components/peopleList.component';

const appRoutes: Routes = [
	//{path:'', component: DefaultComponent},
	//{path:'index', component: DefaultComponent},
	//{path:'index/:page', component: DefaultComponent},
	//{path:'login', component: LoginComponent},
	//{path:'login/:id', component: LoginComponent},
	//{path:'register', component: RegisterComponent},
	//{path:'user-edit', component: UserEditComponent},
	//{path:'task-new', component: TaskNewComponent},
	//{path:'task/:id', component: TaskDetailComponent},
	//{path:'task-edit/:id', component: TaskEditComponent},
	//{path:'**', component: LoginComponent}
	//{path:'users/listar', component: ListaUsuariosComponent},
	{path:'', component: PeopleListComponent}
];

export const appRoutingProviders: any[] = [];
export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);