import React from 'react';
import Enzyme,{mount} from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import HomePage from '../../src/pages/home';
Enzyme.configure({ adapter: new Adapter() });

test('HomePage', () => {
  const wrapper = mount(<HomePage />);
  expect(wrapper.find('div').text()).toBe('Home Page');
});