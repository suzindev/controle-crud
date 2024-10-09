import { Component, EventEmitter, inject, Input, Output } from '@angular/core';
import { Marca } from '../../../models/marca';
import { FormsModule } from '@angular/forms';
import { MdbFormsModule } from 'mdb-angular-ui-kit/forms';
import { MarcaService } from '../../../services/marca.service';
import { ActivatedRoute } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-marcasdetails',
  standalone: true,
  imports: [MdbFormsModule, FormsModule],
  templateUrl: './marcasdetails.component.html',
  styleUrl: './marcasdetails.component.scss'
})
export class MarcasdetailsComponent {
  @Input("marca") marca: Marca = new Marca();
  @Output("retorno") retorno = new EventEmitter<any>();

  routerActivated = inject(ActivatedRoute);
  marcaService = inject(MarcaService);

  constructor() {
    let id = this.routerActivated.snapshot.params['id'];

    if (id > 0) {
      this.marcaService.findById(id).subscribe({
        next: retorno => {
          this.marca = retorno;
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
    if (this.marca.id > 0) {
      this.marcaService.update(this.marca, this.marca.id).subscribe({
        next: mensagem => {
          Swal.fire({
            title: mensagem,
            icon: 'success',
            confirmButtonText: 'OK'
          });

          this.retorno.emit(this.marca);
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
      this.marcaService.save(this.marca).subscribe({
        next: mensagem => {
          Swal.fire({
            title: mensagem,
            icon: 'success',
            confirmButtonText: 'OK'
          });

          this.retorno.emit(this.marca);
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
}
