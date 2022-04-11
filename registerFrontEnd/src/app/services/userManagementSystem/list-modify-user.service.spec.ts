import { TestBed } from '@angular/core/testing';

import { ListModifyUserService } from './list-modify-user.service';

describe('ListModifyUserService', () => {
  let service: ListModifyUserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ListModifyUserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
