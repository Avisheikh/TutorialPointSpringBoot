import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetListUserComponent } from './get-list-user.component';

describe('GetListUserComponent', () => {
  let component: GetListUserComponent;
  let fixture: ComponentFixture<GetListUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetListUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetListUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
