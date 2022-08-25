import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { MainpageComponent } from "./pages/mainpage/mainpage.component";
import { BaseDeDatosComponent } from './pages/base-de-datos/base-de-datos.component';
import { CargaDeDatosComponent } from './pages/carga-de-datos/carga-de-datos.component';



const routes: Routes = [
    {
      path: "",
      component: MainpageComponent,
      pathMatch: "full"
    },
    {
      path: "datos",
      component: BaseDeDatosComponent
    },
    {
      path: "cargar",
      component: CargaDeDatosComponent
    },
  // {
  //   path: "servicios",
  //   component: ServiciosPageComponent
  // },
  // {
  //   path: "contacto",
  //   component: ContactoPageComponent
  // },
  // {
  //   path: "login",
  //   component: LoginPageComponent
  // },
  // {
  //   path: "registrar",
  //   component: RegisterComponent
  // },
  // {
  //   path: "formularios",
  //   component: ListaPersonasComponent
  // },
]

@NgModule({
  imports: [
    ReactiveFormsModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class AppRoutingModule {}
