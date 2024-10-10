import { Component, inject, TemplateRef, ViewChild } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MdbFormsModule } from 'mdb-angular-ui-kit/forms';
import { Carro } from '../../../models/carro';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { CarroService } from '../../../services/carro.service';
import { MarcaslistComponent } from "../../marcas/marcaslist/marcaslist.component";
import { Marca } from '../../../models/marca';
import { MdbModalRef, MdbModalService } from 'mdb-angular-ui-kit/modal';

@Component({
  selector: 'app-carrosdetails',
  standalone: true,
  imports: [MdbFormsModule, FormsModule, MarcaslistComponent, MarcaslistComponent],
  templateUrl: './carrosdetails.component.html',
  styleUrl: './carrosdetails.component.scss'
})
export class CarrosdetailsComponent {
  carro: Carro = new Carro();

  routerActivated = inject(ActivatedRoute);
  router = inject(Router);

  modalService = inject(MdbModalService);
  @ViewChild("modalMarcaLista") modalMarcaLista!: TemplateRef<any>;
  modalRef!: MdbModalRef<any>;

  carroService = inject(CarroService);

  constructor() {
    let id = this.routerActivated.snapshot.params['id'];

    if (id > 0) {
      this.carroService.findById(id).subscribe({
        next: retorno => {
          this.carro = retorno;
        },
        error: erro => {
          Swal.fire({
            title: 'Ocorreu um erro',
            icon: 'error',
            confirmButtonText: 'OK'
          });
        }
      });
    }
  }

  save() {
    if (this.carro.id > 0) {
      this.carroService.update(this.carro, this.carro.id).subscribe({
        next: mensagem => {
          Swal.fire({
            title: mensagem,
            icon: 'success',
            confirmButtonText: 'OK'
          });

          this.router.navigate(['admin/carros'], { state: { carroEditado: this.carro } });
        },
        error: erro => {
          Swal.fire({
            title: 'Ocorreu um erro',
            icon: 'error',
            confirmButtonText: 'OK'
          });
        }
      });
    } else {
      debugger;
      this.carroService.save(this.carro).subscribe({
        next: mensagem => {
          Swal.fire({
            title: mensagem,
            icon: 'success',
            confirmButtonText: 'OK'
          });

          this.router.navigate(['admin/carros'], { state: { carroNovo: this.carro } });
        },
        error: erro => {
          Swal.fire({
            title: 'Ocorreu um erro',
            icon: 'error',
            confirmButtonText: 'OK'
          });
        }
      });
    }
  }

  buscarMarca() {
    this.modalRef = this.modalService.open(this.modalMarcaLista, { modalClass: 'modal-lg' });
  }

  retornoMarca(marca: Marca) {
    this.carro.marca = marca;
    this.modalRef.close();
  }
}
