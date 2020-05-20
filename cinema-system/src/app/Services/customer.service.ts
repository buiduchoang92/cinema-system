import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http' ;
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
	public API = 'http://localhost:8080/customers';
  public API2 = 'http://localhost:8080/tickets';
  public API3 = 'http://localhost:8080/movies';

  constructor(
  	public http: HttpClient
  	) { }
  getCustomerById(customerId): Observable<any> {
  return this.http.get(this.API + '/' + customerId)
	}
	getAllCustomers(): Observable<any> {
  	return this.http.get(this.API)
  }

  // hhien
  addCustomer(customer): Observable<any> {
    return this.http.post(this.API ,customer)
  }

  editCustomer(customer, customerid): Observable<any> {
    return this.http.put(this.API + '/' + customerid,customer)
  }
  deleteCustomer(customerId):Observable<any>{
    return this.http.delete(this.API + '/' + customerId)
  }
// hhien

  getTicketById(ticketId): Observable<any> {
    return this.http.get(this.API2 + '/' + ticketId)
  }
  getAllMovies(): Observable<any>{
    return this.http.get(this.API3  )
  }

  addNewFilm(film): Observable<any> {
    return this.http.post(this.API3+ '/add', film)
  }
  editFilm(film): Observable<any>{
    return this.http.put(this.API3 + '/edit', film)
  }

  delFilm(id): Observable<any>{
  return this.http.delete(this.API3 + '/delete' + id);
}

}
