import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CenterContainerComponent } from "./pages/center-container/center-container.component";
import { WelcomeComponent } from "./pages/welcome/welcome.component";

const routes: Routes = [
  { path: '', redirectTo: 'welcome', pathMatch: 'full' },
  { path: 'welcome', component: WelcomeComponent },
  { path: 'exchange', component: CenterContainerComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {
}
