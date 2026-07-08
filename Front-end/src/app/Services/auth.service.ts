import { Injectable, computed, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';

export interface LoginRequest {
  email: string;
  password: string;
}

export interface RegisterRequest {
  name: string;
  email: string;
  password: string;
  confirmedPassword: string;
}

export interface AuthenticationResponse {
  access_token: string;
  refresh_token: string;
  token_type: string;
}

@Injectable({ providedIn: 'root' })
export class AuthService {
  private readonly apiUrl = 'http://localhost:8080/api/v1/auth';
  private readonly accessTokenKey = 'itquiz_access_token';
  private readonly refreshTokenKey = 'itquiz_refresh_token';
  private readonly tokenTypeKey = 'itquiz_token_type';

  private readonly accessToken = signal<string | null>(this.getStoredAccessToken());

  readonly isAuthenticated = computed(() => Boolean(this.accessToken()));

  constructor(private http: HttpClient) {}

  login(payload: LoginRequest): Observable<AuthenticationResponse> {
    return this.http.post<AuthenticationResponse>(`${this.apiUrl}/login`, payload).pipe(
      tap((response) => this.storeTokens(response))
    );
  }

  register(payload: RegisterRequest): Observable<void> {
    return this.http.post<void>(`${this.apiUrl}/register`, payload);
  }

  logout(): void {
    localStorage.removeItem(this.accessTokenKey);
    localStorage.removeItem(this.refreshTokenKey);
    localStorage.removeItem(this.tokenTypeKey);
    this.accessToken.set(null);
  }

  getAccessToken(): string | null {
    return this.accessToken();
  }

  private storeTokens(response: AuthenticationResponse): void {
    localStorage.setItem(this.accessTokenKey, response.access_token);
    localStorage.setItem(this.refreshTokenKey, response.refresh_token);
    localStorage.setItem(this.tokenTypeKey, response.token_type);
    this.accessToken.set(response.access_token);
  }

  private getStoredAccessToken(): string | null {
    return localStorage.getItem(this.accessTokenKey);
  }
}
