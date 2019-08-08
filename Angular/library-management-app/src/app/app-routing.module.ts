import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


import { GenerateReportComponent } from './generate-report/generate-report.component';
import { AddBookComponent } from './add-book/add-book.component';
import { AddDVDComponent } from './add-dvd/add-dvd.component';
import { DeleteItemComponent } from './delete-item/delete-item.component';
import { ReturnBookComponent } from './return-book/return-book.component';
import { BorrowBookComponent } from './borrow-book/borrow-book.component';
import { DiplayBookComponent } from './diplay-book/diplay-book.component';
import { DiplayDvdComponent } from './diplay-dvd/diplay-dvd.component';


const appRoutes: Routes = [
    {
        path: '',
        component: AddBookComponent,
    },
    {
        path: 'add-book',
        component: AddBookComponent,
    },
    {
        path: 'add-dvd',
        component: AddDVDComponent,
    },
    {
        path: 'delete-item',
        component: DeleteItemComponent,
    },
    {
        path: 'display-book',
        component: DiplayBookComponent
    },
    {
        path: 'display-dvd',
        component: DiplayDvdComponent
    },
    {
        path: 'borrow-item',
        component: BorrowBookComponent
    },

    {
        path: 'return-item',
        component: ReturnBookComponent,
    },

    {
        path: 'generate-report',
        component: GenerateReportComponent
    },
];

@NgModule({
    imports: [RouterModule.forRoot(appRoutes)],
    exports: [RouterModule]
})
export class AppRoutingModule {

}
