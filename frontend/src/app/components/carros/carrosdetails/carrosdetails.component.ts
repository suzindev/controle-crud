import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MdbFormsModule } from 'mdb-angular-ui-kit/forms';
import { Carro } from '../../../models/carro';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-carrosdetails',
  standalone: true,
  imports: [MdbFormsModule, FormsModule],
  templateUrl: './carrosdetails.component.html',
  styleUrl: './carrosdetails.component.scss'
})
export class CarrosdetailsComponent {
  carro: Carro = new Carro();
  routerActivated = inject(ActivatedRoute);
  router = inject(Router);

  constructor() {
    let id = this.routerActivated.snapshot.params['id'];

    if (id > 0) {
      this.findById(id);
    }
  }

  findById(id: number) {
    let carroRetornado: Carro = new Carro();
    carroRetornado.id = 1;
    carroRetornado.nome = "Fiesta";

    this.carro = carroRetornado;
  }

  save() {
    if (this.carro.id > 0) {
      Swal.fire({
        title: 'Editado com sucesso!',
        icon: 'success',
        confirmButtonText: 'OK'
      });

      this.router.navigate(['admin/carros'], { state: { carroEditado: this.carro } });
    } else {
      Swal.fire({
        title: 'Salvo com sucesso!',
        icon: 'success',
        confirmButtonText: 'OK'
      });

      this.router.navigate(['admin/carros'], { state: { carroNovo: this.carro } });
    }
  }
}
