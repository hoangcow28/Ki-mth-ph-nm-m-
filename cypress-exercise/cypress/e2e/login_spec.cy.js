describe('Login Test', () => {
  it('Kịch bản 1: Kiểm tra đăng nhập thành công', () => {
    cy.visit('https://www.saucedemo.com');
    cy.get('#user-name').type('standard_user');
    cy.get('#password').type('secret_sauce');
    cy.get('#login-button').click();
    cy.url().should('include', '/inventory.html');
  });
});
it('Kịch bản 2: Kiểm tra đăng nhập thất bại', () => {
  cy.visit('https://www.saucedemo.com');
  cy.get('#user-name').type('invalid_user');
  cy.get('#password').type('wrong_password');
  cy.get('#login-button').click();
  cy.get('.error-message-container').should('contain', 'Username and password do not match');
});